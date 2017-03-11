/**
 * Created by Joshua on 2017/3/11.
 */
public interface Deque <Item> {
    /** Return the size of thr deque */
    public int size();

    /** Return true if the deque id empty */
    public boolean isEmpty();

    /** Add an item to the front of the deque */
    public void addFirst(Item i);

    /** Add an item to the end of the deque */
    public void addLast(Item i);

    /** Print all the item in the deque separate with a space */
    public void printDeque();

    /** Remove and return the first item of the deque
     * return null if the deque is empty */
    public Item removeFirst();

    /** Remove and return the last item of the deque
     * return null if the deque is empty */
    public Item removeLast();

    /** Return the item in the index-th position
     * return null if not exsited
     */
    public Item get(int index);
}
