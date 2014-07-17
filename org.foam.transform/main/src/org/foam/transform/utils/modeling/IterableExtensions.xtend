package org.foam.transform.utils.modeling

import java.util.Collection
import com.google.common.collect.HashMultimap

class IterableExtensions {

	/**
	 * Example:
	 *  #["x","y","a","b","c","a","b"].split[it == "a"].forEach[println(join(", "))]
	 * 
	 * Output: 
	 *   x, y
	 *   a, b, c
	 *   a, b
	 */
	def static <T> Iterable<? extends Iterable<T>> split(Iterable<T> input, (T) => boolean delimPredicate) {
		input.fold(
			<Collection<T>> newArrayList(<T>newArrayList),
			[multiList, item|
				var currentList = multiList.last
				if(delimPredicate.apply(item)) {
					currentList = <T> newArrayList
					multiList.add(currentList)
				}
				currentList.add(item)
				return multiList
			]
		)
	}

	/**
	 * Consumes the head element and checks its value against the given predicate.
	 * Returns a view on this iterable that contains all the elements except the first.
	 */
	def static <T> Iterable<T> checkConsumed(Iterable<T> input, (T) => boolean checkPredicate) {
		if( ! checkPredicate.apply(input.head) ) {
			throw new Exception("The consumed element does not satisfy the given predicate")
		}
		return input.tail
	}
	
	def static <K,V> HashMultimap<K,V> toHashMultimap(Iterable<Pair<K,V>> input) {
		input.fold(
			// this transforms the list into a multimap
			HashMultimap.<K, V>create,
			[mmap, p|
				mmap.put(p.key, p.value)
				mmap
			]
		)
	}
}