package org.foam.transform.utils.modeling

import com.google.common.collect.HashMultimap
import com.google.common.collect.Multimap
import java.util.Collection

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
	
	/**
	 * Converts a stream of pairs into a MultiMap where the keys are the keys from the pairs
	 * and each item in the MultiMap is a set of values with the same key.
	 */
	def static <K,V> HashMultimap<K,V> toMultimap(Iterable<Pair<K,V>> input) {
		input.fold(
			// this transforms the list into a MultiMap
			HashMultimap.<K, V>create,
			[mmap, p|
				mmap.put(p.key, p.value)
				mmap
			]
		)
	}
	
	/**
	 * Converts a stream of pairs into a MultiMap where the keys are the keys and values
	 * are computed using a lambda function which returns a Pair<K,V>
	 * Example: users.toMultimap[user| user.id -> user ]
	 */
	def static <K,V> Multimap<K,V> toMultimap(Iterable<V> input, (V) => Pair<K,V> computeKeyValuePair) {
		input.map[computeKeyValuePair.apply(it)].toMultimap
	}
	
	/**
	 * Zips two iterables without throwing NoSuchElementException.
	 * The zipped iterable will have the same length as the shorter of the two input iterables.
	 */
	def static <T,U> Iterable<Pair<T,U>> zip(Iterable<T> first, Iterable<U> second) {
		return new ZippingIterable(first, second)
		
		// NOTE: The following approach works only
		// for iterables with the same cardinality
		// 
		//   val sndIter = snd.iterator
		//   return fst.map[it -> sndIter.next]
	}
}