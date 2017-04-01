/**
 * Created by Joshua on 2017/2/25.
 */
public class LinkedListDeque<Blorp> implements Deque<Blorp> {
    /**
     * Single node of the LinkedListDeque
     */
    private class Node {
        private Blorp item;
        private Node prev;
        private Node next;

        Node(Blorp i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    /**
     * Private field:
     * A single sentinel to create a circle LinkedListDeque.
     * size to save the size.
     */
    private Node sentinel; // sentinel.next is the first Node
    private int size;  // Always save the size of the LinkedList

    /*
     Notes on private item comments:
     Always write out the invariant about the private fields.
    */

    /**
     * Constructor:
     * With empty parameter.
     */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }




    /**
     * Constructor :
     * with a single item
     */
    public LinkedListDeque(Blorp blorp) {

        // The logic of the sentinal node
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

        // Add a new node to the LinkedListDeque
        this.addFirst(blorp);
    }

    /*
     Notes one the constructor of the LinkedListDeque:
     We need first construct the sentinel node.
     Then we can apply
     sentinel.next = sentinel;
     sentinel.prev = sentinel;
     To it.
     That's why we need set all the arguments to
     be null.
    */

    /**
     * Add a node at the first position of it.
     * @param blorp
     */
    @Override
    public void addFirst(Blorp blorp) {
        sentinel.next = new Node(blorp, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;


        // Increment the size
        size += 1;
    }

    /**
     * Add a node to the last node of the Deque
     */
    @Override
    public void addLast(Blorp blorp) {
        sentinel.prev = new Node(blorp, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;

        size += 1;
    }

    /*
     Notes on a single confuse:
     Why we need to set last.next = sentinel?
     We donnot want special cases on there is only the sentinel node.
    */

    public Blorp getFirst() {
        return sentinel.next.item;
    }

    public Blorp getLast() {
        return sentinel.prev.item;
    }

    /**
     * @return true if there is only one sentinel node.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * return the total numbers of node.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * print the items of all nodes in the
     * LinkedListDeque.
     */
    @Override
    public void printDeque() {
        printDequeHelper(sentinel.next);
    }

    /**
     * Print all the node start at front.
     * @param front
     */
    private void printDequeHelper(Node front) {
        if (front != sentinel) {
            // recursive case, front is not the end of the sentinel
            System.out.print(front.item + " ");
            printDequeHelper(front.next);
        }
    }

    /**
     * Removes and returns the item at the front of the Deque.
     * If no such item exists, returns null.
     */
    @Override
    public Blorp removeFirst() {
        if (!isEmpty()) {
            // Not empty
            Blorp blorp = sentinel.next.item;


            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;

            return blorp;
        }

        // LinkedListDeque is empty
        return null;
    }

    /**
     * Removes and returns the item at the end of the Deque.
     * If no such item exists, returns null.
     */
    @Override
    public Blorp removeLast() {
        if (!isEmpty()) {
            // Not empty
            Blorp blorp = sentinel.prev.item;

            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;

            // refresh size
            size -= 1;

            return blorp;
        }

        // LinkedListDeque is empty
        return null;
    }

    /**
     * return the item in the <index>th node.
     * @param index
     * @return
     */
    @Override
    public Blorp get(int index) {
        Node p = sentinel.next;
        while (index > 0 && p != sentinel) {
            p = p.next;
            index--;
        }

        return p.item;

    }

    /**
     * return the item in the <index>th node
     * using recursive function.
     * @param index
     * @return
     */
    public Blorp getRecursive(int index) {
        return getRecutsiveHelper(sentinel.next, index);
    }

    private Blorp getRecutsiveHelper(Node front, int n) {
        if (n == 0 || front == sentinel) {
            return front.item;
        }

        return getRecutsiveHelper(front.next, n - 1);
    }

}
