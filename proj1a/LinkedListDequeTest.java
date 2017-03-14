import sun.net.www.content.text.Generic;

import java.nio.IntBuffer;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	public static boolean checkEqual(Integer expected, Integer actual) {
		if (expected != actual) {
			System.out.println("get() returned " + actual + ", but expected : " + expected);
			return false;
		}
		return true;
	}
	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");

		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");
		
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);

	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");


		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty 
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);

	}

	/* test the add first, add last, remove first, remove last method */

	public static void addRemoveFirstLastTest() {

	    System.out.println("Running add/remove first/last test.");

	    LinkedListDeque <Integer> lld = new LinkedListDeque<Integer>();
	    lld.addFirst(2);
	    lld.addLast(3);
	    lld.addFirst(1);
	    lld.addLast(4);

	    boolean passed = checkEqual(4, lld.removeLast());
	    passed = checkEqual(1,lld.removeFirst()) && passed;

	    printTestStatus(passed);
    }

	public static void getTest() {

		System.out.println("Running get/getRecursion test.");

		LinkedListDeque <Integer> lld1 = new LinkedListDeque<Integer>();
		// check get implied on empty list
        System.out.println("Running emplty list get test");
		boolean passed = checkEqual(null, lld1.get(0));
		passed = checkEqual(null, lld1.getrecursion(0)) && passed;

		lld1.addFirst(1);
		lld1.addLast(2);
		lld1.addLast(3);

		// check get implied on actual list
        System.out.println("Running non-emplty list get test");
		passed = checkEqual(3, lld1.get(2)) && passed;
		passed = checkEqual(3, lld1.getrecursion(2)) && passed;

		// check index out of rantge
        System.out.println("Running list get test when index is out of range");
		passed = checkEqual((Integer)null, lld1.get(4)) && passed;
		passed = checkEqual((Integer)null, lld1.getrecursion(4)) && passed;

		// the original list must not change
        System.out.println("check if the size is the same, i.e. the list is the same");
		passed = checkSize(3, lld1.size()) && passed;

		printTestStatus(passed);
	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
		addRemoveFirstLastTest();
		getTest();
	}
} 