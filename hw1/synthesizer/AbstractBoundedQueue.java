package synthesizer;

/**
 * Created by Joshua on 2017/3/19.
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {

    // The number of elements in the Queue
    protected int fillCount;

    // The actually capacity of the Queue
    protected int capacity;

    /** Return the actually content of the Queue
     */
    public int capacity() {
        return capacity;
    }

    /** Return the number of the elements
     */
    public int fillCount() {
        return fillCount;
    }

    /** Return true if fillCount == 0 */
    public boolean isEmpty() {
        return fillCount == 0;
    }

    /** Return true if fillCount == capacity */
    public boolean isFull() {
        return capacity == fillCount;
    }

    public abstract T peek();
    public abstract T dequeue();
    public abstract void enqueue(T x);
}
