import java.util.Objects;

/**
 * Created by Xiao Shi on 2017/3/13.
 */
public class ArrayDeque <Gen> {

    private Gen[] items;
    private int size;
    private int first_index;
    private int last_index;
    private int update_constant = 2;

    public ArrayDeque() {
        items = (Gen[]) new Object[100];
        first_index = 0;
        last_index = 0;
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
        if (size < 0.25 * items.length) {
            updateArray(size / update_constant);
        }
    }

    private int findPrev(int index) {
        return (100 + (index - 1)) % 100;
    }

    private int findNext(int index) {
        updateArrayWhenNeeded();
        if (index < items.length) {
            index += 1;
        }
        index = items.length - index;
        return index;
    }

    public void addFirst (Gen item) {
        updateArrayWhenNeeded();
        first_index = findPrev(first_index);
        items[first_index] = item;
        size ++;
    }

    public void addLast (Gen item) {
        updateArrayWhenNeeded();
        last_index = findNext(last_index);
        items[last_index] = item;
        size ++;
    }

    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int ptr = first_index;
        for (int i = 0; i <= size; i ++) {
            System.out.println(items[ptr]);
            ptr = findNext(ptr);
        }
    }

    public Gen removeFirst() {
        updateArrayWhenNeeded();
        Gen removed = items[first_index];
        first_index = findNext(first_index);
        size --;
        return removed;
    }

    public Gen removeLast() {
        updateArrayWhenNeeded();
        Gen removed = items[last_index];
        last_index = findPrev(last_index);
        size --;
        return removed;
    }

    public Gen get(int index) {
        return items[index];
    }
}
