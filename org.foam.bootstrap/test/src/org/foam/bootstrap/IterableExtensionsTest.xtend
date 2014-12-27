package org.foam.bootstrap

import org.junit.Test

import static org.junit.Assert.*

import static extension org.foam.bootstrap.IterableExtensions.*

class IterableExtensionsTest {

	@Test def void testSplit() {
		assertArrayEquals(
			#[#["x","y"], #["a","b","c"], #["a","b"]],
			#["x","y","a","b","c","a","b"].split[it == "a"]
		)

		assertArrayEquals(
			#[#[], #["a","b","c"], #["a","b"]],
			#["a","b","c","a","b"].split[it == "a"]
		)

		assertArrayEquals(
			#[#[], #["a"], #["a"]],
			#["a","a"].split[it == "a"]
		)

		assertArrayEquals(
			#[#[]],
			#[].split[it == "a"]
		)
	}

	@Test def void testCheckConsumed() {
		val list = #[1,2,3,4]

		assertArrayEquals(
			#[],
			list
			.checkConsumed[it == 1]
			.checkConsumed[it == 2]
			.checkConsumed[it == 3]
			.checkConsumed[it == 4] as int[]
		)
		
		assertArrayEquals(
			#[3,4],
			list
			.checkConsumed[it == 1]
			.checkConsumed[it == 2] as int[]
		)

		try {
			list.checkConsumed[it == 2]
			fail
		} catch(Exception e) {}
	}

	@Test def void testToMultimapUsingPairs() {
		val data = #[
			1 -> 10,
			2 -> 20,
			3 -> 30,
			1 -> 11,
			2 -> 21,
			3 -> 31
		]
		
		val mmap = data.toMultimap
		
		assertEquals(6, mmap.size)
		assertEquals(3, mmap.keySet.size)

		assertArrayEquals(#[30,31], mmap.get(3).sort.toArray)
		assertArrayEquals(#[20,21], mmap.get(2).sort.toArray)
		assertArrayEquals(#[10,11], mmap.get(1).sort.toArray)

	}
	
	@Test def void testToMultimapUsingLambda() {
		val data = #[10,20,30,11,12,31,14]
		val mmap = data.toMultimap[(it / 10) -> it]
		
		assertEquals(7, mmap.size)
		assertEquals(3, mmap.keySet.size)

		assertArrayEquals(#[10,11,12,14], mmap.get(1).sort.toArray)
		assertArrayEquals(#[20], mmap.get(2))
		assertArrayEquals(#[30,31], mmap.get(3).sort.toArray)
	}
	
	@Test def void testZipIterables() {
		assertArrayEquals(
			#[1->1, 2->2],
			zip(#[1,2,3], #[1,2])
		)
		assertArrayEquals(
			#[1->1, 2->2],
			zip(#[1,2], #[1,2,3])
		)
		assertArrayEquals(
			#[1->1, 2->2, 3->3],
			zip(#[1,2,3], #[1,2,3])
		)
		assertArrayEquals(
			#[],
			zip(#[], #[])
		)
	}
	
	@Test def void testZipWithIterables() {
		assertArrayEquals(
			#[2, 4],
			zipWith(#[1,2,3], #[1,2], [a, b | a + b])
		)
		assertArrayEquals(
			#[2, 4],
			zipWith(#[1,2], #[1,2,3], [a, b | a + b])
		)
		assertArrayEquals(
			#[2, 4, 6],
			zipWith(#[1,2,3], #[1,2,3], [a, b | a + b])
		)
		assertArrayEquals(
			#[],
			zipWith(#[], #[], [a, b | a + b])
		)
	}

	@Test def void testTransitiveClosureLimits() {
		assertArrayEquals("empty closure is ok", #[] as int[], 0.transitiveClosure[])

		try{ // cannot start from null
			assertNull(null.transitiveClosure[])
			fail
		} catch(NullPointerException e) {}
	}
	
	@Test def void testTransitiveClosureOnDAG() {
		
		val DAG = #[
			1->2, 1->3,
			2->4, 2->5,
			3->4,
			4->6,
			5->6
		].toMultimap
		
		assertArrayEquals(#[2,3,4,5,6], 1.transitiveClosure[DAG.get(it)].sort)
		assertArrayEquals(#[4,5,6],     2.transitiveClosure[DAG.get(it)].sort)
		assertArrayEquals(#[4,6],       3.transitiveClosure[DAG.get(it)].sort)
	}
	
	@Test def void testTransitiveClosureOnNODAG() {
		val NODAG = #[
			1->2, 2->3, 3->4, 4->1, 3->5, 5->6
		].toMultimap
		
		assertArrayEquals(#[1,2,3,4,5,6], 1.transitiveClosure[NODAG.get(it)].sort)
		assertArrayEquals(#[1,2,3,4,5,6], 3.transitiveClosure[NODAG.get(it)].sort)
		assertArrayEquals(#[6],           5.transitiveClosure[NODAG.get(it)].sort)
	}
}