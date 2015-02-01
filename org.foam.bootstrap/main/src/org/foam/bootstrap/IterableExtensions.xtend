package org.foam.bootstrap

import com.google.common.base.Preconditions
import com.google.common.collect.HashMultimap
import com.google.common.collect.Multimap
import java.util.Collection
import java.util.Iterator
import java.util.Set
import org.eclipse.xtend.lib.annotations.Data

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
	@Pure def static <K,V> HashMultimap<K,V> toMultimap(Iterable<Pair<K,V>> input) {
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
	@Pure def static <K,V> Multimap<K,V> toMultimap(Iterable<V> input, (V) => Pair<K,V> computeKeyValuePair) {
		input.map[computeKeyValuePair.apply(it)].toMultimap
	}
	
	/**
	 * Zips two iterables without throwing NoSuchElementException.
	 * The zipped iterable will have the same length as the shorter of the two input iterables.
	 * The result is a stream of pairs.
	 */
	@Pure def static <T,U> zip(Iterable<T> first, Iterable<U> second) {
		zipWith( first, second, [ a,b | a->b ] )
	}
	
	/**
	 * Similar to the zip() function, however, the last argument is a lambda
	 * which produces the output items.
	 */
	@Pure def static <T,U,V> Iterable<V> zipWith(Iterable<T> first, Iterable<U> second, (T,U) => V mapFunction) {
		new ZippingWithIterable(first, second, mapFunction)
	}
	
	/**
	 * Helper class that encapsulates the zipping behavior.
	 * Its constructor is generated automagically by Xtend due to the @Data annotation.
	 */
	@Data private static class ZippingWithIterable<T, U, V> implements Iterable<V> {
	
		private val Iterable<T> iterable1
		private val Iterable<U> iterable2
		private val (T,U) => V mapFunction
	
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
	
	/**
	 * Computes a transitive closure over a graph using a given lambda function.
	 * It returns an {@link Set} of visited objects which does not contain the starting node.
	 * If the given graph is <b>not</b> a DAG, the algorithm performs a topological sort first.
	 * Example usage:
	 * <pre>
	 * // collects all preceded use-cases of the use-case uc9 (uc9 will not be returned)
	 * uc9.trasitiveClosure[preceded]
	 * </pre>
	 * 
	 * @param node starting node
	 * @param closureFunction.
	 */
	@Pure def static <T> Set<T> transitiveClosure(T node, (T) => Iterable<T> closureFunction) {
		
		Preconditions.checkNotNull(node)
		Preconditions.checkNotNull(closureFunction)
		
		val visited = <T> newHashSet
		trasitiveClosureHelper(node, closureFunction, visited)
		return visited
	}

	def private static <T> void trasitiveClosureHelper(T node, (T) => Iterable<T> closureFunction, Set<T> visited) {
		val nextList = closureFunction.apply(node)
		if(nextList != null) {
			for(next : nextList) {
				if( ! visited.contains(next) ) {
					visited += next
					trasitiveClosureHelper(next, closureFunction, visited)
				}
			}
		}
	}

	/**
	 * This version works on DAGs only, but should perform better in a multi-threaded environment
	 * because there is no shared state. 
	 */
	@Pure def static <T> Iterable<T> transitiveClosureDAG(T node, (T) => Iterable<T> closureFunction) {
		#[node] + closureFunction.apply(node).map[transitiveClosureDAG(closureFunction)].flatten
	}
	
}