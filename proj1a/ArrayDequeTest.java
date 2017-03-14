/**
 * Created by Xiao Shi on 2017/3/14.
 */
public class ArrayDequeTest {

    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println ("isEmpty() returned " + actual +  ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public  static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println ("isEmpty() returned " + actual +  ", but expected: " + expected);
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

    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println ("Test passed!");
        }
        System.out.println ("Test failed!");
    }

    /* test the return of add in an empty array
     * launch the empty array, size should be 0
     * when add few itesm, size should be correct, isEmpty() should be false
     * then print out the list
     */
    public static void addInEmptyArrayTest() {
        System.out.println ("Start test of add in empty array list");

        ArrayDeque alst = new ArrayDeque();
        // check empty list isEmpty and check empty list's size
        boolean passed = checkEmpty(true, alst.isEmpty());
        passed = checkSize(0, alst.size()) && passed;

        alst.addFirst("hello");
        alst.addLast("world");

        passed = checkEmpty(false, alst.isEmpty()) && passed;
        passed = checkSize(2, alst.size()) && passed;

        printTestStatus(passed);
        alst.printDeque();
    }

    /* add in and then remove the item, and list is empty*/

    public static void addRemoveArrayTest() {
        System.out.println("Start test of add and remove arry list");

        ArrayDeque <String> alst = new ArrayDeque<>();
        alst.addFirst("hello");
        alst.removeFirst();

        boolean passed = checkSize(0, alst.size());
        passed = checkEmpty(true, alst.isEmpty()) && passed;

        printTestStatus(passed);

    }

    /* test the add first, add last, remove first, remove last method*/
    public static void addRemoveFirstLastTest() {

        System.out.println ("Start test of add and remove last and first test.");

        ArrayDeque <Integer> alst = new ArrayDeque<>();
        alst.addFirst(2);
        alst.addFirst(1);
        alst.addLast(3);
        alst.addLast(4);

        boolean passed = checkEqual(4, alst.removeLast());
        passed = checkEqual(1, alst.removeFirst()) && passed;

        printTestStatus(passed);
    }

    /* test the get method */
    public static void getTest() {

        System.out.println("Start test of get method");

        ArrayDeque <Integer> alst = new ArrayDeque<>();

        // test get method on empty list
        boolean passed = checkEqual((Integer)null, alst.get(0));

        alst.addFirst(1);
        alst.addLast(2);
        alst.addLast(3);

        passed = checkEqual(1,alst.get(0)) && passed;
        passed = checkEqual(2,alst.get(1)) && passed;

        printTestStatus(passed);
    }

    public static void main(String[] args) {
        addInEmptyArrayTest();
        addRemoveArrayTest();
        addRemoveFirstLastTest();
        getTest();
    }

}
