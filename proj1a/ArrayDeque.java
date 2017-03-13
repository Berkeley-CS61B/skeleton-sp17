import java.util.Objects;

/**
 * Created by Xiao Shi on 2017/3/13.
 */
public class ArrayDeque <Gen> {

    private Gen[] items;
    private int size;
    private int first_index;
    private int update_constant = 2;

    public ArrayDeque() {
        items = (Gen[]) new Object[100];
        first_index = 0;
        size = 0;
    }

    private void updateArray(int capacity) {
        Gen[] a = (Gen[]) new Objects[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    private void updateArrayWhenNeeded() {
        if (size == items.length) {
            updateArray(size * update_constant);
        }
    }

    private int findPrev(int index) {
        return (100 + (index - 1)) % 100;
    }

    public void addFirst (Gen item) {
        updateArrayWhenNeeded();
        first_index = findPrev(first_index);
        items[first_index] = item;
        size ++;

    }

    public void addLast (Gen item) {
        updateArrayWhenNeeded();
        it
    }

    public boolean isEmplty() {
        return true;
    }

    public int size() {
        return 0;
    }

    public void printDeque() {

    }

    public gen removeFirst() {
        return null;
    }

    public gen removeLast() {
        return null;
    }

    public gen get(int index) {
        return null;
    }
}
