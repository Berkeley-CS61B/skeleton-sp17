/**
 * Created by Joshua on 2017/3/11.
 */
public interface Deque<Item> {
    /** Return the size of thr deque */
    int size();

    /** Return true if the deque id empty */
    boolean isEmpty();

    /** Add an item to the front of the deque */
    void addFirst(Item i);

    /** Add an item to the end of the deque */
    void addLast(Item i);

    /** Print all the item in the deque separate with a space */
    void printDeque();

    /** Remove and return the first item of the deque
     * return null if the deque is empty */
    Item removeFirst();

    /** Remove and return the last item of the deque
     * return null if the deque is empty */
    Item removeLast();

    /** Return the item in the index-th position
     * return null if not exsited
     */
    Item get(int index);
}
