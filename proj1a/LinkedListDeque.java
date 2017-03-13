import sun.security.krb5.internal.PAForUserEnc;

import java.util.Iterator;

/**
 * Created by Xiao Shi on 2017/3/13.
 */
public class LinkedListDeque<Genetic> {
    private class IntNode {
        public IntNode prev;
        public Genetic item;
        public IntNode next;

        public IntNode(IntNode previous, Genetic content, IntNode following) {
            prev = previous;
            item = content;
            next = following;
        }
    }

    // circular sentinal node
    private IntNode sentinal;
    private int size;

    //constructor with null
    public LinkedListDeque() {
        sentinal = new IntNode(sentinal, 24, sentinal);
        size = 0;
    }

    //constructor
    public LinkedListDeque (Genetic item) {
        sentinal = new IntNode(sentinal, 24, sentinal);
        IntNode new_node = new IntNode(null, item, null);
        sentinal.next = new_node;
        new_node.prev = sentinal;
        sentinal.prev = new_node;
        new_node.next = sentinal;
        size += 1;
    }


    public void addFirst (Genetic item) {
        IntNode new_node = new IntNode(null, item, null);
        new_node.next = sentinal.next;
        sentinal.next = new_node;
        new_node.next.prev = new_node;
        new_node.prev = sentinal;
        size += 1;
    }

    public void addLast (Genetic item) {
        IntNode new_node = new IntNode(null, item, null);
        new_node.prev = sentinal.prev;
        sentinal.prev = new_node;
        new_node.prev.next = new_node;
        new_node.next = sentinal;
        size += 1;
    }

    public boolean isEmplty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        IntNode ptr = sentinal.next;
        while (ptr != sentinal) {
            System.out.println(ptr.item);
            ptr = ptr.next;
        }
    }

    public Genetic removeFirst() {
        if (size == 0) {
            return null;
        }
        IntNode removed = sentinal.next;
        sentinal.next = removed.next;
        removed.next.prev = sentinal;
        return removed.item;
    }

    public Genetic removeLast() {
        if (size == 0) {
            return null;
        }
        IntNode removed = sentinal.prev;
        sentinal.prev = removed.prev;
        removed.prev.next = sentinal;
        return removed.item;
    }

    public Genetic get(int index) {
        if (index >= size) {
            return null;
        }
        IntNode ptr = sentinal.next;
        int counter = 0;
        while (counter < index) {
            ptr = ptr.next;
            index ++;
        }
        return ptr.item;
    }

    public Genetic getrecursion(int index) {
        if (size == 0 && index != 0) {
            return null;
        } else if (size != 0 && index == 0) {
            return sentinal.next.item;
        }
        return getrecursion(index - 1);
    }
}
