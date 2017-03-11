/**
 * Created by Joshua on 2017/2/25.
 */
public class ArrayDeque<Item> implements Deque<Item> {

    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /**
     * The default constructor of ArrayDeque
     */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    /**
     * Return the size of ArrayDeque
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Return True if there is no item in the ArrayDeque
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /** Calculate the index that immedietaly before the index
     * Think the ArrayDeque recursively
     */
    private int minusOne(int index) {

        if (index == 0) {
            index = items.length;
        }

        index -= 1;

        return index;
    }

    /** Calculate the index that immedietaly after the index
     * Think the ArrayDeque recursively
     */
    private int addOne(int index) {

        if (index == items.length - 1) {
            index = -1;
        }

        index += 1;

        return index;
    }

    private static int REFACTOR = 2;

    /** Resuze the ArrayDeque with a specific
     * capacity
     */
    private void resize(int capacity) {
        Item[] newItems = (Item[]) new Object[capacity];

        // Copy the first to items to the right side of the newItems
        int first = addOne(nextFirst);
        System.arraycopy(items, first, newItems,
                newItems.length - (items.length - first), items.length - first);
        // Copy the rest of the item to the left of the neItems
        System.arraycopy(items, 0, newItems, 0, size - (items.length - first));

        // Refresh the nextLast(nextLast is still that value) and nextFirst
        nextFirst = newItems.length - (items.length - first) - 1;

        items = newItems;
    }

    /**
     * Add a item to the front of the ArrayDeque
     */
    @Override
    public void addFirst(Item i) {
        if (size == items.length) {
            resize(size * REFACTOR);
        }

        items[nextFirst] = i;

        // Refresh size and nextFront
        size += 1;
        // Make the ArrayDeque circular
        if (nextFirst == 0) {
            nextFirst = items.length;
        }
        nextFirst -= 1;
    }

    /**
     * Add a item to the last position of the ArrayDeque
     */
    @Override
    public void addLast(Item i) {
        if (size == items.length) {
            resize(size * REFACTOR);
        }

        items[nextLast] = i;

        // Refresh size and nextLast
        size += 1;
        // Make the ArrayDeque circular
        if (nextLast == items.length - 1) {
            nextLast = -1;
        }
        nextLast += 1;
    }

    /**
     * Print the deque from first to last, separate by a space
     */
    @Override
    public void printDeque() {
        int i = 0;
        while (i < size) {
            nextFirst = addOne(nextFirst);
            System.out.print(items[nextFirst] + " ");
            i += 1;
        }

        System.out.println();
    }

    /**
     * Remove and return the item in the front of the Deque,
     * return null if not exist.
     */
    @Override
    public Item removeFirst() {
        if (size > 16 && size < items.length / 4) {
            resize(size / REFACTOR);
        }

        // If the Deque is empty
        if (size == 0) {
            return null;
        }

        int first = addOne(nextFirst);
        Item oldFirst = items[first];
        nextFirst = first;
        items[first] = null;
        size -= 1;

        return oldFirst;
    }


    /**
     * Remove and return the item in the end of the Deque,
     * return null if not exist.
     */
    @Override
    public Item removeLast() {
        if (size > 16 && size < items.length / 4) {
            resize(size / REFACTOR);
        }
        if (size == 0) {
            return null;
        }

        int last = minusOne(nextLast);
        Item oldLast = items[last];
        nextLast = last;
        items[last] = null;
        size -= 1;

        return oldLast;
    }

    /** Get the item in the ith index */
    @Override
    public Item get(int index) {
        if (size == 0 || index < 0 || index > size) {
            return null;
        }

        // Get first index
        int first = addOne(nextFirst);
        if (first + index >= items.length) {
            // Circular condition
            return items[(first + index) - items.length];
        }

        return items[first + index];
    }

}
