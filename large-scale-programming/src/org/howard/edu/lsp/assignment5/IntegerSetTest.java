package org.howard.edu.lsp.assignment5;

import org.howard.edu.lsp.assignment5.IntegerSet.IntegerSetException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class IntegerSetTest {
	
	IntegerSet my_set;

	@BeforeEach
	void setUp() throws Exception {
		my_set = new IntegerSet();
	}

	@AfterEach
	void tearDown() throws Exception {
		my_set = null;
	}
		
	@Test
	void testClear() {
		my_set.add(1);
		my_set.clear();
		assertEquals(my_set.int_set.size(), 0);
	}
	
	@Test
	void testLength() {
		my_set.add(5);
		my_set.add(10);
		my_set.add(15);
		my_set.add(20);
		assertTrue(my_set.length() == 4);
	}
	
	@Test
	void testEquals() {
		IntegerSet that_set = new IntegerSet();
		that_set.add(1);
		my_set.add(1);
		assertTrue(my_set.equals(that_set));
	}
	
	@Test
	void testContains() {
		my_set.add(35);
		assertTrue(my_set.contains(35));
	}
	
	@Test
	void testLargest() throws IntegerSetException {
		my_set.add(10);
		my_set.add(20);
		my_set.add(30);
		my_set.add(40);
		my_set.add(50);
		assertTrue(my_set.largest() == 50);
	}
	
	@Test
	void testLargestException() {
		assertThrows(IntegerSetException.class, () -> my_set.largest());
	}
	
	@Test
	void testSmallest() throws IntegerSetException {
		my_set.add(20);
		my_set.add(40);
		my_set.add(60);
		my_set.add(80);
		assertTrue(my_set.smallest() == 20);
	}
	
	@Test
	void testSmallestException() {
		assertThrows(IntegerSetException.class, () -> my_set.smallest());
	}
	
	@Test
	void testAdd() {
		IntegerSet that_set = new IntegerSet();
		that_set.add(2);
		that_set.add(4);
		that_set.add(6);
		
		my_set.add(2);
		my_set.add(4);
		my_set.add(6);
		
		assertTrue(that_set.equals(my_set));
	}
	
	@Test
	void testRemove() {
		my_set.add(50);
		my_set.add(100);
		my_set.add(150);
		my_set.remove(150);
		
		assertFalse(my_set.contains(150));
	}
	
	@Test
	void testUnion() {
		IntegerSet that_set = new IntegerSet();
		my_set.add(1);
		my_set.add(2);
		my_set.add(3);
		my_set.add(4);
		
		that_set.add(5);
		that_set.add(6);
		
		my_set.union(that_set);
		assertEquals(my_set.int_set, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
	}
	
	@Test
	void testIntersect() {
		IntegerSet that_set = new IntegerSet();
		my_set.add(5);
		my_set.add(10);
		my_set.add(15);
		my_set.add(20);
		
		that_set.add(10);
		that_set.add(20);
		that_set.add(30);
		that_set.add(40);
		
		my_set.intersect(that_set);
		assertEquals(my_set.int_set, new ArrayList<Integer>(Arrays.asList(10, 20)));
	}
	
	@Test
	void testDifference() {
		IntegerSet that_set = new IntegerSet();
		my_set.add(20);
		my_set.add(40);
		my_set.add(60);
		
		that_set.add(30);
		that_set.add(40);
		that_set.add(50);
		
		my_set.diff(that_set);
		assertEquals(my_set.int_set, new ArrayList<Integer>(Arrays.asList(20, 60)));
	}
	
	@Test
	void testEmpty() {
		assertTrue(my_set.isEmpty());
	}
	
	@Test
	void testString() {
		my_set.add(1);
		my_set.add(2);
		my_set.add(3);
		my_set.add(4);
		my_set.add(5);
		
		assertEquals(my_set.toString(), "1, 2, 3, 4, 5, ");
	}
}
