/**
 * Created by Xiao Shi on 2017/4/10.
 */
public interface Deque<Item> {
    public void printDeque();

    public Item getRecursive(int i);

    public Item removeFirst();

    public Item removeLast();

    public void addLast(Item x);

    public void addFirst(Item x);

    public boolean isEmpty();

    public Item get(int index);

    public int size();

}
