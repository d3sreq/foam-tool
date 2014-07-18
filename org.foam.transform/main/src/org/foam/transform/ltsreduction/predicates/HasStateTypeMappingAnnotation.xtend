package org.foam.transform.ltsreduction.predicates

import com.google.common.base.Predicate
import java.util.Collection
import java.util.Collections
import org.foam.lts.State
import org.foam.traceability.StateType
import org.foam.traceability.StateTypeMappingAnnotation

/**
 * Evaluates to True if given State has {@link StateTypeMappingAnnotation} attached
 * with same {@link StateType} as given in constructor.
 */
class HasStateTypeMappingAnnotation implements Predicate<State> {
	
	val Collection<StateType> stateTypesToRetain
	
	new(Collection<StateType> stateTypesToRetain) {
		this.stateTypesToRetain = stateTypesToRetain
	}
	
	new (StateType stateTypeToRetain) {
		this(Collections.singleton(stateTypeToRetain))
	}
	
	new() {
		this(StateType.values.toList.unmodifiableView)
	}
	
	override apply(State state) {
		val annotation = state.annotations.filter(StateTypeMappingAnnotation).head
		annotation != null && stateTypesToRetain.contains(annotation.stateType)
	}
	
}