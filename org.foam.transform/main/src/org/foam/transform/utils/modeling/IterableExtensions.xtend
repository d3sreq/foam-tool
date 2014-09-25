package org.foam.transform.utils.modeling

import com.google.common.collect.HashMultimap
import com.google.common.collect.Multimap
import java.util.Collection
import org.eclipse.xtext.xbase.lib.Functions.Function2
import org.eclipse.xtend.lib.annotations.Data
import java.util.Iterator

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
	 * The result is a stream of pairs.
	 */
	def static <T,U> zip(Iterable<T> first, Iterable<U> second) {
		zipWith( first, second, [ a,b | a->b ] )
	}
	
	/**
	 * Similar to the zip() function, however, the last argument is a lambda
	 * which produces the output items.
	 */
	def static <T,U,V> Iterable<V> zipWith(Iterable<T> first, Iterable<U> second, Function2<T,U,V> mapFunction) {
		new ZippingWithIterable(first, second, mapFunction)
	}
	
	/**
	 * Helper class that encapsulates the zipping behavior.
	 * Its constructor is generated automagically by Xtend due to the @Data annotation.
	 */
	@Data private static class ZippingWithIterable<T, U, V> implements Iterable<V> {
	
		private val Iterable<T> iterable1
		private val Iterable<U> iterable2
		private val Function2<T,U,V> mapFunction
	
		override iterator() {
			return new Iterator<V>() {
	
				private val iterator1 = iterable1.iterator
				private val iterator2 = iterable2.iterator
	
				override hasNext() {
					iterator1.hasNext && iterator2.hasNext
				}
	
				override next() {
					mapFunction.apply(iterator1.next, iterator2.next)
				}
	
				override remove() {
					throw new UnsupportedOperationException
				}
			}
		}
	}
}