import sun.net.www.content.text.Generic;
import sun.security.krb5.internal.PAForUserEnc;

import java.util.Iterator;

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
            index ++;
        }
        return ptr.item;
    }

    public LinkedListDeque copyLink() {
        LinkedListDeque copy = new LinkedListDeque();
        StuffNode ptr = sentinal.next;
        for (int i = 0; i < size; i++) {
            addLast(ptr.item);
            ptr = ptr.next;
        }
        return copy;
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
}
