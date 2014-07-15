package org.foam.transform.utils.modeling

import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.EMap

@Deprecated
class MappingExtensions {
	
	/**
	 * Emulates Multimap.put method.
	 */
	def static <T, V> putToMultimap(EMap<T, EList<V>> multimap, T key, V value) {
		if (!multimap.contains(key)) {
			multimap.put(key, new BasicEList<V>)
		}
		multimap.get(key).add(value)
	}
	
}