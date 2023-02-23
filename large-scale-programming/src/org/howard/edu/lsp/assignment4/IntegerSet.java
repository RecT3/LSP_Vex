package org.howard.edu.lsp.assignment4;

import java.util.*;

public class IntegerSet {

	private List<Integer> int_set;
	
	public IntegerSet() {
		int_set = new ArrayList<Integer>();
	}
	
	public class IntegerSetException extends Exception {
		public IntegerSetException(String error) {
			super(error);
		}
	}
	
	public List<Integer> get_set() {
		return int_set;
	}
	
	public void set_set(List<Integer> new_set) {
		int_set = new_set;
	}
	
	public void clear() {
		int_set.clear();
	}
	
	public int length() {
		return int_set.size();
	}
	
	public boolean equals(IntegerSet a) {
		if (int_set.size() != a.length()) {
			return false;
		}
		else {
			return int_set.containsAll(a.int_set);
		}
	}
	
	public boolean contains(int value) {
		return int_set.contains(value);
	}
	
	public int largest() throws IntegerSetException {
		if (int_set.isEmpty()) {
			throw new IntegerSetException("The Set is Empty.");
		}
		else {
			int max = int_set.get(0);
			for (int i = 0; i < int_set.size(); i++) {
				if (int_set.get(i) > max) {
					max = int_set.get(i);
				}
			}
			return max;
		}
	}
	
	public int smallest() throws IntegerSetException {
		if (int_set.isEmpty()) {
			throw new IntegerSetException("The Set is Empty.");
		}
		else {
			int min = int_set.get(0);
			for (int i = 0; i < int_set.size(); i++) {
				if (int_set.get(i) < min) {
					min = int_set.get(i);
				}
			}
			return min;
		}
	}
	
	public void add(int item) {
		if (int_set.contains(item) == false) {
			int_set.add(item);
		}
	}
	
	public void remove(int item) {
		if (int_set.contains(item) == true) {
			int_set.remove(int_set.indexOf(item));
		}
	}
	
	public void union(IntegerSet b) {
		for (int i = 0; i < b.length(); i++) {
			if (int_set.contains(b.int_set.get(i)) == false) {
				int_set.add(b.int_set.get(i));
			}
		}
	}
	
	public void intersect(IntegerSet b) {
		int_set.retainAll(b.int_set);
	}
	
	public void diff(IntegerSet b) {
		for (int i = 0; i < b.length(); i++) {
			if (int_set.contains(b.int_set.get(i)) == true) {
				int_set.remove(b.int_set.get(i));
			}
		}
	}
	
	public boolean isEmpty() {
		return int_set.isEmpty();
	}
	
	public String toString() {
		String list = "";
		for (int i = 0; i < int_set.size(); i++) {
			list += int_set.get(i).toString() + ", ";
		}
		return list;
	}
	
	public static void main(String[] args) {
		try {
			IntegerSet set1 = new IntegerSet();
			for (int i = 1; i <= 10; i++) {
				set1.add(i);
			}
	
			System.out.println("Value of Set 1 is: " + set1.toString() + "\n");
			System.out.println("Smallest value in Set 1 is: " + set1.smallest());
			System.out.println("Largest value in Set 1 is: " + set1.largest() + "\n");
			
			System.out.println("Removed 3 from Set 1.");
			set1.remove(3);
			System.out.println("New value of Set 1: " + set1.toString() + "\n");
			
			System.out.println("Removed 8 from Set 1.");
			set1.remove(8);
			System.out.println("New value of Set 1: " + set1.toString() + "\n");
			
			System.out.println("Remove 100 from Set 1.");
			set1.remove(100);
			System.out.println("New value of Set 1: " + set1.toString() + "\n");
			
			System.out.println("Set 1 is Empty (true/false)");
			System.out.println(set1.isEmpty() + "\n");
			
			System.out.println("Set 1 contains 9? (true/false)");
			System.out.println(set1.contains(9) + "\n");
			
			System.out.println("Length of Set 1: " + set1.length() + "\n");
			
			set1.clear();
			for (int i = 1; i <= 10; i++) {
				set1.add(i);
			}
			IntegerSet set2 = new IntegerSet();
			for (int i = 0; i <= 20; i += 2) {
				set2.add(i);
			}
			System.out.println("Value of Set 1 is: " + set1.toString());
			System.out.println("Value of Set 2 is: " + set2.toString());
			System.out.println("We will reset the values of each list after every test." + "\n");
			
			System.out.println("Union of Set 1 and Set 2");
			set1.union(set2);	// union of set1 and set2
			System.out.println("Result of union of Set 1 and Set 2");
			System.out.println(set1.toString() + "\n");	// result of union of set1 and set2
			set1.clear();
			for (int i = 1; i <= 10; i++) {
				set1.add(i);
			}
			set2.clear();
			for (int i = 0; i <= 20; i += 2) {
				set2.add(i);
			}
			
			System.out.println("Difference of Set 1 and Set 2");
			set1.diff(set2);
			System.out.println(set1.toString() + "\n");
			set1.clear();
			for (int i = 1; i <= 10; i++) {
				set1.add(i);
			}
			set2.clear();
			for (int i = 0; i <= 20; i += 2) {
				set2.add(i);
			}
			
			System.out.println("Difference of Set 2 and Set 1");
			set2.diff(set1);
			System.out.println(set2.toString() + "\n");
			set1.clear();
			for (int i = 1; i <= 10; i++) {
				set1.add(i);
			}
			set2.clear();
			for (int i = 0; i <= 20; i += 2) {
				set2.add(i);
			}
			
			System.out.println("Intersection of Set 1 and Set 2");
			set1.intersect(set2);
			System.out.println(set1.toString() + "\n");
			set1.clear();
			for (int i = 1; i <= 10; i++) {
				set1.add(i);
			}
			set2.clear();
			for (int i = 0; i <= 20; i += 2) {
				set2.add(i);
			}
			System.out.println("Are Set 1 and Set 2 equal?");
			System.out.println(set1.equals(set2) + "\n");
			
			System.out.println("Catching the exception");
			set1.clear();
			set1.largest();
		}
		catch (IntegerSetException e) {
			System.out.println(e);
		}

	}
}
