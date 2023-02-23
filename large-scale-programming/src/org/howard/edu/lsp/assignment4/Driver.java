package org.howard.edu.lsp.assignment4;

import org.howard.edu.lsp.assignment4.IntegerSet.IntegerSetException;

public class Driver {
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
