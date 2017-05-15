//import edu.princeton.cs.algs4.GaussianElimination;
//import sun.net.www.content.text.Generic;
//import sun.security.krb5.internal.PAForUserEnc;
//
//import java.util.Iterator;

/**
 * Created by Xiao Shi on 2017/3/13.
 */
public class LinkedListDeque<Genetic> {
    private class StuffNode {
        public StuffNode prev;
        public Genetic item;
        public StuffNode next;

        public StuffNode(StuffNode previous, Genetic content, StuffNode following) {
            prev = previous;
            item = content;
            next = following;
        }
    }

    // circular sentinal node
    private StuffNode sentinal;
    private int size;
    private Genetic sentinal_item;

    //constructor with null
    public LinkedListDeque() {
        sentinal = new StuffNode(null, sentinal_item, null);
        sentinal.next = sentinal;
        sentinal.prev = sentinal;
        size = 0;
    }

    //constructor
    public LinkedListDeque (Genetic item) {
        sentinal = new StuffNode(sentinal, sentinal_item, sentinal);
        StuffNode new_node = new StuffNode(null, item, null);
        sentinal.next = new_node;
        new_node.prev = sentinal;
        sentinal.prev = new_node;
        new_node.next = sentinal;
        size += 1;
    }


    public void addFirst (Genetic item) {
        StuffNode new_node = new StuffNode(null, item, null);
        new_node.next = sentinal.next;
        sentinal.next = new_node;
        new_node.prev = sentinal;
        new_node.next.prev = new_node;
        size += 1;
    }

    public void addLast (Genetic item) {
        StuffNode new_node = new StuffNode(null, item, null);
        new_node.prev = sentinal.prev;
        sentinal.prev = new_node;
        new_node.next = sentinal;
        new_node.prev.next = new_node;
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        StuffNode ptr = sentinal.next;
        while (ptr != sentinal) {
            System.out.println(ptr.item);
            ptr = ptr.next;
        }
    }

    public Genetic removeFirst() {
        if (size == 0) {
            return (Genetic)null;
        }
        StuffNode removed = sentinal.next;
        sentinal.next = removed.next;
        removed.next.prev = sentinal;
        size -= 1;
        return removed.item;
    }

    public Genetic removeLast() {
        if (size == 0) {
            return (Genetic)null;
        }
        StuffNode removed = sentinal.prev;
        sentinal.prev = removed.prev;
        removed.prev.next = sentinal;
        size -= 1;
        return removed.item;
    }

    public Genetic get(int index) {
        if (size == 0) {
            return (Genetic)null;
        } else if (index >= size) {
            return (Genetic)null;
        }
        StuffNode ptr = sentinal.next;
        int counter = 0;
        while (counter < index) {
            ptr = ptr.next;
            counter ++;
        }
        return ptr.item;
    }

    public Genetic getrecursion(int index) {
        StuffNode i = sentinal.next;
        if (size == 0 || index >= size) {
            return (Genetic) null;
        }
        return getrecursion_helper(i.next, index-1);

    }

    public Genetic getrecursion_helper(StuffNode p, int index) {
        if (index == 0) {
            return p.item;
        }
        return getrecursion_helper(p.next, index - 1);
    }

    /* Add a method to the SLList class that inserts a new element at the given position. If the position
     * is past the end of the list, insert the new node at the end of the list. For example,
     * if the SLList is 5  6  2, insert(10, 1) should result in 5  10  6  2.*/
    public void insert(Genetic item, int pos) {
        if (pos < size) {
            StuffNode add_in = new StuffNode(null, item, null);
            StuffNode ptr = sentinal.next;
            for (int i = 0; i < pos; i++) {
                ptr = ptr.next;
            }
            add_in.prev = ptr.prev;
            add_in.next = ptr;
            ptr.prev = add_in;
            add_in.prev.next = add_in;
            size ++;
        } else {
            this.addLast(item);
        }
    }

    public void reverse() {
        StuffNode ptr = sentinal.next;
        //the last node
        StuffNode reversed = sentinal.prev;
        for (int i = 0; i < size; i++) {
            insert(reversed.item, i);
            removeLast();
            reversed = sentinal.prev;
        }
    }

}
