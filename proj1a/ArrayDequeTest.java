/**
 * Created by Joshua on 2017/3/11.
 */
public class ArrayDequeTest {

    public static void checkAddFirst() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        integerArrayDeque.addFirst(1);
        integerArrayDeque.addFirst(2);
        integerArrayDeque.addFirst(3);
        integerArrayDeque.addFirst(4);
        integerArrayDeque.addFirst(5);
        integerArrayDeque.addFirst(6);
        integerArrayDeque.addFirst(7);
        integerArrayDeque.addFirst(8);
        integerArrayDeque.addLast(7);
        integerArrayDeque.addLast(6);
        integerArrayDeque.addLast(5);
        integerArrayDeque.addLast(4);
        integerArrayDeque.addLast(3);
        integerArrayDeque.addLast(2);
        integerArrayDeque.addLast(1);
        integerArrayDeque.addLast(0);
        integerArrayDeque.addLast(-1);
        integerArrayDeque.addLast(-2);

        integerArrayDeque.printDeque();
    }

    public static void checkAddLast() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        integerArrayDeque.addLast(7);
        integerArrayDeque.addLast(6);
        integerArrayDeque.addLast(5);
        integerArrayDeque.addLast(4);
        integerArrayDeque.addLast(3);
        integerArrayDeque.addLast(2);
        integerArrayDeque.addLast(1);
        integerArrayDeque.addLast(0);
        integerArrayDeque.addLast(-1);
        integerArrayDeque.addLast(-2);



        integerArrayDeque.printDeque();


    }

    public static void main(String[] args) {
        checkAddFirst();
    }
}
