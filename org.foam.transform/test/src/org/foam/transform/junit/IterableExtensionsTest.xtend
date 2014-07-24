package org.foam.transform.junit

import static org.junit.Assert.*;
import org.junit.Test

import static extension org.foam.transform.utils.modeling.IterableExtensions.*

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

	@Test def void testToHashMultimap() {
		val data = #[
			1 -> 10,
			2 -> 20,
			3 -> 30,
			1 -> 11,
			2 -> 21,
			3 -> 31
		]
		
		val mmap = data.toHashMultimap
		
		assertEquals(6, mmap.size)
		assertEquals(3, mmap.keySet.size)

		assertArrayEquals(#[30,31], mmap.get(3))
		assertArrayEquals(#[20,21], mmap.get(2))
		assertArrayEquals(#[10,11], mmap.get(1))

	}
}