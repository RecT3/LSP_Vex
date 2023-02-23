package org.howard.edu.lsp.assignment4;

import java.util.*; //for ArrayList<>()

public class IntegerSet {

	private List<Integer> int_set;
	
	//constructor, initializes int_set
	public IntegerSet() {
		int_set = new ArrayList<Integer>();
	}
	
	//creating our own error that just prints out the string that is passed to it
	public class IntegerSetException extends Exception {
		public IntegerSetException(String error) {
			super(error);
		}
	}
	
	//getter method -> (O(1))
	public List<Integer> get_set() {
		return int_set;
	}
	
	//setter method - (O(1))
	public void set_set(List<Integer> new_set) {
		int_set = new_set;
	}
	
	//clears the integer set -> (O(N))
	public void clear() {
		int_set.clear();
	}
	
	//returns the size of the array list -> (O(1))
	public int length() {
		return int_set.size();
	}
	
	//checks if IntegerSet a is the exact same -> (O(N))
	public boolean equals(IntegerSet a) {
		//if they have different lengths they cannot be equal
		if (int_set.size() != a.length()) {
			return false;
		}
		//if they have equal lengths check if all elements are the same
		else {
			return int_set.containsAll(a.int_set);
		}
	}
	
	//check if the IntegerSet contains a value -> (O(N))
	public boolean contains(int value) {
		return int_set.contains(value);
	}
	
	//returns the largest number in the set -> (O(N))
	public int largest() throws IntegerSetException {
		//if the set is empty, throws an exception saying so
		if (int_set.isEmpty()) {
			throw new IntegerSetException("The Set is Empty.");
		}
		//search through the set and find the largest integer
		else {
			//set our comparison to something in the set already
			int large = int_set.get(0);
			//iterate through the set and compare the values to large
			for (int i = 0; i < int_set.size(); i++) {
				//set large to the bigger integer if found
				if (int_set.get(i) > large) {
					large = int_set.get(i);
				}
			}
			return large;
		}
	}
	
	//returns the smallest integer in the set -> (O(N))
	public int smallest() throws IntegerSetException {
		//if the set is empty, throws an exception saying so
		if (int_set.isEmpty()) {
			throw new IntegerSetException("The Set is Empty.");
		}
		//search through the set and find the smallest integer
		else {
			//set our comparison to something in the set already
			int small = int_set.get(0);
			//iterate through the set and compare the values to small
			for (int i = 0; i < int_set.size(); i++) {
				//set small to the smaller integer if found
				if (int_set.get(i) < small) {
					small = int_set.get(i);
				}
			}
			return small;
		}
	}
	//adds an integer to the set if it is not present -> (O(N))
	public void add(int item) {
		if (int_set.contains(item) == false) {
			int_set.add(item);
		}
	}
	
	//removes an integer from the set if it is present -> (O(N))
	public void remove(int item) {
		if (int_set.contains(item) == true) {
			int_set.remove(int_set.indexOf(item));
		}
	}
	
	//calculates the union of two sets -> (O(N))
	public void union(IntegerSet b) {
		for (int i = 0; i < b.length(); i++) {
			if (int_set.contains(b.int_set.get(i)) == false) {
				int_set.add(b.int_set.get(i));
			}
		}
	}
	
	//calculates the intersection of two sets -> (O(N))
	public void intersect(IntegerSet b) {
		int_set.retainAll(b.int_set);
	}
	
	//calculates the difference of two sets -> (O(N))
	public void diff(IntegerSet b) {
		for (int i = 0; i < b.length(); i++) {
			if (int_set.contains(b.int_set.get(i)) == true) {
				int_set.remove(b.int_set.get(i));
			}
		}
	}
	
	//checks if the set is empty -> (O(1))
	public boolean isEmpty() {
		return int_set.isEmpty();
	}
	
	//prints every integer in the set -> (O(N))
	public String toString() {
		String list = "";
		for (int i = 0; i < int_set.size(); i++) {
			list += int_set.get(i).toString() + ", ";
		}
		return list;
	}
}
