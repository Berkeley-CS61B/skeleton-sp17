package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>  {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // To avoid ambiguous,
        this.capacity = capacity;
        fillCount = 0;
        first = 0;
        last = 0;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        // Throw exceptions if no room
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }

        // Add a item to last index
        rb[last] = x;

        // refresh fillCount and update last
        fillCount += 1;
        // If next index is the value of capacity
        if (last + 1 == capacity) {
            last = -1;
        }
        last += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        // If buffer is empty, throw a exception
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }

        // save and then delete the element at the first index
        T deletedItem = rb[first];
        rb[first] = null; // delete it by set it to null

        // decrease fillCount and update first.
        fillCount -= 1;
        // update first
        if (first + 1 == capacity) {
            first = -1;
        }
        first += 1;

        return deletedItem;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        return rb[first];
    }

    @Override
    public Iterator<T> iterator() {
        return new BufferIterator();
    }

    // define a private class that implements the Iterator interface
    private class BufferIterator implements Iterator<T> {
        private int position;

        public BufferIterator() {
            position = first;
        }


        @Override
        public boolean hasNext() {
            // Because we increment first once a time, so
            // at last, we will get to last position
            return position != last;
        }

        @Override
        public T next() {
            T current = rb[position];

            // If position is the last position in the array
            // advance it to 0
            if (position + 1 == capacity) {
                position = -1;
            }

            position += 1;
            return current;
        }
    }
}
