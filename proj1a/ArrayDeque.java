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
    private int array_size = 8;

    public ArrayDeque() {
        items = (Gen[]) new Object[array_size];
        first_index = 0;
        last_index = 0;
        size = 0;
    }

    private void updateArray(int capacity) {
        Gen[] a = (Gen[]) new Object[capacity];
        if (first_index != 0) {
            System.arraycopy(items, first_index, a, 0, array_size - first_index);
            System.arraycopy(items, 0, a, array_size - first_index, last_index+1);
        } else {
            System.arraycopy(items, 0, a, 0, size);
        }
        items = a;
        array_size = capacity;
        first_index = 0;
        last_index = size - 1;
    }

    private void updateArrayWhenNeeded() {
        if (size == array_size) {
            updateArray(array_size * update_constant);
        } else if (size < (0.25 * array_size)) {
            updateArray(array_size / update_constant);
        }
    }

    private int findPrev(int index) {
        return (array_size + (index - 1)) % array_size;
    }

    private int findNext(int index) {
        if (index == array_size - 1) {
            index = 0;
        } else {
            index += 1;
        }
        return index;
    }

    public void addFirst (Gen item) {
        if (size != 0) {
            first_index = findPrev(first_index);
        }
        items[first_index] = item;
        size ++;
        updateArrayWhenNeeded();
    }

    public void addLast (Gen item) {
        if (size != 0) {
            last_index = findNext(last_index);
        }
        items[last_index] = item;
        size ++;
        updateArrayWhenNeeded();
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
        for (int i = 0; i < size; i ++){
            System.out.println(items[ptr]);
            ptr = findNext(ptr);
        }
    }

    public Gen removeFirst() {
        Gen removed = items[first_index];
        size --;
        first_index = findNext(first_index);
        return removed;
    }

    public Gen removeLast() {
        Gen removed = items[last_index];
        size --;
        last_index = findPrev(last_index);
        return removed;
    }

    public Gen get(int index) {
        if (first_index >= last_index && (index >= first_index || index <= last_index)) {
            return items[index];
        } else if (first_index <= last_index && index >= first_index && index <= last_index ) {
            return items[index];
        }
        return null;
    }
}
