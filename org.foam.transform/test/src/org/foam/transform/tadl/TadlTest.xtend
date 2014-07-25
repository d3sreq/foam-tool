package org.foam.transform.tadl

import org.foam.transform.tadllang2tadl.TadlLang2Tadl
import org.foam.transform.utils.modeling.EmfCommons
import org.junit.Assert
import org.junit.Test

class TadlTest {
	
	private extension TadlFormulaBuilderExtension = new TadlFormulaBuilderExtension

	@Test def void testParseCreateUse() {
		
		val expectedTadlTemplate = TADL(
			CTL('at least one branch with use required after create',
				AG(VAR('create') => EF(VAR('use')))
			),
			CTL('only one create',
				AG( VAR('create') => AX(AG( ! VAR('create'))))
			),
			LTL('if there is "use" there must have been a "create" before',
				G(VAR('use') => O(VAR('create')))
			)
		) => [
			variableDefinitions += #[VDEF('create'), VDEF('use')]
		]

		val parser = new TadlLang2Tadl
		val actualTadlTemplate = parser.parse('''
		## at least one branch with use required after create
		CTL AG(create -> EF(use))
		
		## only one create
		CTL AG(create -> AX(AG(!create)))
		
		## if there is "use" there must have been a "create" before
		LTL G(use -> O(create))
		''')

		Assert.assertEquals(
			EmfCommons.asXmiString(expectedTadlTemplate),
			EmfCommons.asXmiString(actualTadlTemplate)
		)
	}

	@Test def void testParseOpenClose() {
		
		val expectedTadlTemplate = TADL(
			CTL('after open close is required',
				AG(VAR('open') => AF(VAR('close')))
			),
			CTL('no multi-open',
				AG(VAR('open') => AX(A(!VAR('open'), VAR('close'))))
			),
			CTL('no multi-close',
				AG(VAR('close') => AX(!E(!VAR('open'), (VAR('close') && !VAR('open')))))
			),
			LTL('if there is "close" there must have been a "open" before',
				G(VAR('close') => O(VAR('open')))
			)
		) => [
			variableDefinitions += #[VDEF('open'), VDEF('close')]
		]

		val parser = new TadlLang2Tadl
		val actualTadlTemplate = parser.parse('''
		## after open close is required
		CTL AG(open -> AF(close))
		
		## no multi-open
		CTL AG(open -> AX(A[!open U close]))
		
		## no multi-close
		CTL AG(close -> AX(!E[!open U (close & !open)]))
		
		## if there is "close" there must have been a "open" before
		LTL G(close -> O(open))
		''')

		Assert.assertEquals(
			EmfCommons.asXmiString(expectedTadlTemplate),
			EmfCommons.asXmiString(actualTadlTemplate)
		)
	}

}
