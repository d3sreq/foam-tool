package org.foam.transform.junit.utils

import java.util.List
import java.util.Set
import org.eclipse.emf.common.util.EMap
import org.foam.annotation.Annotable
import org.foam.annotation.Annotation
import org.foam.annotation.UnknownAnnotation
import org.foam.flowannotation.VariableDefinitionAnnotation
import org.foam.propositionallogic.VariableDefinition
import org.foam.ucm.Scenario
import org.foam.ucm.ScenarioHolder
import org.foam.ucm.Step
import org.foam.ucm.UseCase
import org.foam.ucm.UseCaseModel

import static org.junit.Assert.*

// TODO: this should be an extension
// TODO: refactor - assertions can be replaced with EcoreUtil2.equals
class UcmChecker {

	def void assertUseCaseModelEquals(UseCaseModel expected, UseCaseModel actual) {
		assertUseCaseListEquals(expected.useCases, actual.useCases)
		assertAnnotationsEquals(expected, actual)
	}

	def void assertUseCaseEquals(UseCase expected, UseCase actual) {
		assertEquals(expected.id, actual.id)
		assertEquals(expected.name, actual.name)
		assertScenarioEquals(expected.mainScenario, actual.mainScenario)
		assertBranchesEquals(expected.branches, actual.branches)
		assertUseCaseListEquals(expected.preceeded.sortBy[id], actual.preceeded.sortBy[id])
	}

	def void assertScenarioEquals(Scenario expected, Scenario actual) {
		assertEquals(expected.label, actual.label)
		assertEquals(expected.text, actual.text)

		// assert that steps equals
		assertEquals(expected.steps.size, actual.steps.size)

		for (i : (0 .. expected.steps.size - 1)) {
			assertStepEquals(expected.steps.get(i), actual.steps.get(i))
		}
	}

	def void assertStepEquals(Step expected, Step actual) {
		assertEquals(expected.label, actual.label)
		assertEquals(expected.text, actual.text)
		assertAnnotationsEquals(expected, actual)
	}

	def assertScenarioHolderEquals(ScenarioHolder expected, ScenarioHolder actual) {
		assertEquals(expected.extensions.size, actual.extensions.size)
		assertEquals(expected.variations.size, actual.variations.size)

		if (!expected.extensions.empty) {
			for (i : 0 .. expected.extensions.size - 1) {
				assertScenarioEquals(expected.extensions.get(i), actual.extensions.get(i))
			}
		}

		if (!expected.variations.empty) {
			for (i : 0 .. expected.variations.size - 1) {
				assertScenarioEquals(expected.variations.get(i), actual.variations.get(i))
			}
		}
	}

	def private assertAnnotationsEquals(Annotable expected, Annotable actual) {
		assertEquals(expected.annotations.size, actual.annotations.size)
		if (!expected.annotations.empty) {
			for (i : 0 .. expected.annotations.size - 1) {
				assertAnnotationEquals(expected.annotations.get(i), actual.annotations.get(i))
			}
		}
	}

	def dispatch void assertAnnotationEquals(UnknownAnnotation expected, UnknownAnnotation actual) {
		val msg = String::format("Annotation - expected: %s but was: %s", expected, actual)
		assertArrayEquals(msg, expected.parts, actual.parts)
	}

	def dispatch void assertAnnotationEquals(VariableDefinitionAnnotation expected, VariableDefinitionAnnotation actual) {
		assertVariableDefinitionEquals(expected.variableDefinition, actual.variableDefinition)
	}

	def protected assertVariableDefinitionEquals(VariableDefinition expected, VariableDefinition actual) {
		assertEquals(expected.name, actual.name)
	}

	def dispatch void assertAnnotationEquals(Annotation expected, Annotation actual) {
		assertTypeEquals(expected, actual)
	}

	def private void assertUseCaseListEquals(List<UseCase> expected, List<UseCase> actual) {
		assertEquals(expected.size, actual.size)
		if (!expected.empty) {
			for (i : (0 .. expected.size - 1)) {
				assertUseCaseEquals(expected.get(i), actual.get(i))
			}
		}
	}

	def assertBranchesEquals(EMap<Step, ScenarioHolder> expected, EMap<Step, ScenarioHolder> actual) {
		val expectedStepIdsMap = expected.keySet.mapToStepIds
		val actualStepIdsMap = actual.keySet.mapToStepIds

		val expectedKeys = expectedStepIdsMap.keySet.sort.unmodifiableView
		val actualKeys = actualStepIdsMap.keySet.sort.unmodifiableView
		
		assertArrayEquals(
			"Steps associated with branches are different than expected",
			expectedKeys, actualKeys
		)

		for (stepId : expectedStepIdsMap.keySet) {
			val expectedScenarioHolder = expected.get(expectedStepIdsMap.get(stepId))
			val actualScenarioHolder = actual.get(actualStepIdsMap.get(stepId))

			assertScenarioHolderEquals(expectedScenarioHolder, actualScenarioHolder)
		}
	}

	def private void assertTypeEquals(Annotation expected, Annotation actual) {
		assertTrue(
			'''Annotation doesn't have expected type. Expected: "«expected.getClass»" but was "«actual.getClass»"''',
			expected.getClass.isInstance(actual)
		)
	}

	def private mapToStepIds(Set<Step> steps) {
		steps.fold(newHashMap, [m, s|m.put(s.label, s); m])
	}

}