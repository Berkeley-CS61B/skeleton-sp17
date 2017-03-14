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
        System.arraycopy(items, 0, a, 0, size);
        items = a;
        array_size = capacity;
    }

    private void updateArrayWhenNeeded() {
        if (size == array_size) {
            updateArray(array_size * update_constant);
        }
        /*长变短的时候，因为我定义不是从0开始，可能占到后面*/
//        } else if (size <= (0.25 * array_size)) {
//            updateArray(array_size / update_constant);
//        }
    }

    private int findPrev(int index) {
        return (array_size + (index - 1)) % array_size;
    }

    private int findNext(int index) {
        updateArrayWhenNeeded();
        if (index < array_size) {
            index += 1;
        }
        index = array_size - index;
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
