package org.foam.transform.junit

import org.foam.cntex.CntexFactory
import org.foam.transform.cntexlang2cntex.CntexLang2Cntex
import org.foam.transform.junit.utils.CntexChecker
import org.junit.Test

class CntexLang2CntexTest {
	
	val cntexFac = CntexFactory.eINSTANCE
	val cntexLang2CntEx = new CntexLang2Cntex
	val cntexChecker = new CntexChecker
	
	@Test def parseCounterExample() {
		val input = '''
			*** This is NuSMV 2.5.4 (compiled on Fri Oct 28 14:13:29 UTC 2011)
			*** Enabled addons are: compass 
			*** For more information on NuSMV see <http://nusmv.fbk.eu>
			*** or email to <nusmv-users@list.fbk.eu>.
			*** Please report bugs to <nusmv-users@fbk.eu>
			
			*** Copyright (c) 2010, Fondazione Bruno Kessler
			
			*** This version of NuSMV is linked to the CUDD library version 2.4.1
			*** Copyright (c) 1995-2004, Regents of the University of Colorado
			
			*** This version of NuSMV is linked to the MiniSat SAT solver. 
			*** See http://www.cs.chalmers.se/Cs/Research/FormalMethods/MiniSat
			*** Copyright (c) 2003-2005, Niklas Een, Niklas Sorensson 
			
			-- specification AG (tadl_open_registration -> AF tadl_close_registration)  is false
			-- as demonstrated by the following execution sequence
			Trace Description: CTL Counterexample 
			Trace Type: Counterexample 
			-> State: 1.1 <-
			  s = init0
			  incl_UC208_from_UC1_step_4b2b1 = FALSE
			-> State: 1.3 <-
			  s = init0$-guard-$UC1_1_JMP$-act-$UC1_1_JMP
			-- Loop starts here
			-> State: 1.18 <-
			  s = UC101_5_JMP
			-> State: 1.19 <-
			  s = UC101_5_EXT
			-- specification AG (tadl_close_registration -> AX !E [ !tadl_open_registration U (tadl_close_registration & !tadl_open_registration) ] )  is true
			-- specification AG (tadl_open_registration -> AX A [ !tadl_open_registration U tadl_close_registration ] )  is false
			-- as demonstrated by the following execution sequence
			Trace Description: CTL Counterexample 
			Trace Type: Counterexample 
			-> State: 2.1 <-
			  s = init0
			  incl_UC208_from_UC1_step_4b2b1 = FALSE
		'''
		
		val expectedOutput = cntexFac.createCounterExample => [
			specifications += cntexFac.createSpecification => [
				textFormula = "AG (tadl_open_registration -> AF tadl_close_registration)"
				trace = cntexFac.createTrace => [
					states += cntexFac.createCntExState => [
						assignments += cntexFac.createCntExAssignment => [
							variableName = "s"
							value = "init0"
						]
						assignments += cntexFac.createCntExAssignment => [
							variableName = "incl_UC208_from_UC1_step_4b2b1"
							value = "FALSE"
						]
					]
					states += cntexFac.createCntExState => [
						assignments += cntexFac.createCntExAssignment => [
							variableName = "s"
							value = "init0$-guard-$UC1_1_JMP$-act-$UC1_1_JMP"
						]
					]
					
					val loopState = cntexFac.createCntExState => [
						assignments += cntexFac.createCntExAssignment => [
							variableName = "s"
							value = "UC101_5_JMP"
						]
					]
					states += loopState
					loopStart = loopState
					
					states += cntexFac.createCntExState => [
						assignments += cntexFac.createCntExAssignment => [
							variableName = "s"
							value = "UC101_5_EXT"
						]
					]
				]
			]
			
			specifications += cntexFac.createSpecification => [
				textFormula = "AG (tadl_close_registration -> AX !E [ !tadl_open_registration U (tadl_close_registration & !tadl_open_registration) ] )"
			]
			
			specifications += cntexFac.createSpecification => [
				textFormula = "AG (tadl_open_registration -> AX A [ !tadl_open_registration U tadl_close_registration ] )"
				trace = cntexFac.createTrace => [
					states += cntexFac.createCntExState => [
						assignments += cntexFac.createCntExAssignment => [
							variableName = "s"
							value = "init0"
						]
						assignments += cntexFac.createCntExAssignment => [
							variableName = "incl_UC208_from_UC1_step_4b2b1"
							value = "FALSE"
						]
					]
				]
			]
		]
		
		val actualCounterExample = cntexLang2CntEx.transform(input)
		cntexChecker.assertCounterExampleEquals(expectedOutput, actualCounterExample)
	}
}