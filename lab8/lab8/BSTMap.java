package lab8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

/**
 * Created by Joshua on 3/30/2017.
 *
 * Use a BST data structure to save a map
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    /** represent a single node of Map */
    private class Node {
        /*
         1. private fields:
         2. key-value pairs
         3. link to right/left subtree
         4. size of a tree which start with this node
         */
        private K key;
        private V value;
        private Node left, right;
        private int N;

        /** Node constructor: construct a discrete node with left/right null link */
        public Node(K k, V v, int n) {
            key = k;
            value = v;
            N = n;
        }
    }

    // private field: only the root value
    private Node root;

    // We use the deafault constructor to construct a BSTMap

    /**
     * Removes all of the mappings from this map.
     */
    @Override
    public void clear() {
        root = null;
    }

    /** return true if the map contains the key */
    @Override
    public boolean containsKey(K key) {
        return containsKey(key, root) != null;
    }

    /** Helper function for containsKey, return the node if we find the node in
     * the map, if not, return null.
     */
    private Node containsKey(K key, Node x) {
        // We donnot find the key
        if (x == null) {
            return null;
        }

        int comp = key.compareTo(x.key);
        if (comp == 0) {
            // key is in the left subtree of x
            return x;
        } else if (comp < 0) {
            // key is in the node x
            return containsKey(key, x.left);
        } else {
            // key is in the right subtree of x
            return containsKey(key, x.right);
        }
    }


    /** Return the value which associated with key
     * null -- indicate we cannot find the key */
    @Override
    public V get(K key) {
        // Do error checking
        if (get(key, root) == null) {
            return null;
        }

        return get(key, root).value;
    }

    /** Search for key in the tree which starts at x */
    private Node get(K key, Node x) {
        if (x == null) {
            // it's a empty tree, we search fail
            return null;
        }

        // key is either in the x or in the left/right subtree
        int comp = key.compareTo(x.key);
        if (comp == 0) {
            return x;
        } else if (comp < 0) {
            return get(key, x.left);
        } else {
            return get(key, x.right);
        }

    }

    /** Return the size of the tree */
    @Override
    public int size() {
        return size(root);
    }

    /** Return the size of tree which start at node x */
    private int size(Node x) {
        // Error checking: empty tree
        // we cannot use x.N
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }


    /** Insert a pair to the map, if the key is already in the map,
     * just change the value associated with the key
     */
    @Override
    public void put(K key, V value) {
        root = put(key, value, root);
    }

    /** Helper function for put, put a pair to the map, return the puted map */
    private Node put(K key, V value, Node x) {
        // x is a empty subtree, just return a new node contains the key.
        if (x == null) {
            return new Node(key, value, 1);
        }

        int comp = key.compareTo(x.key);
        // x is in the left subtree of x
        if (comp < 0) {
            x.left = put(key, value, x.left);
        } else if (comp == 0) {
            // x is in exactly x
            x.value = value;
        } else {
            // x is in the right subtree of x
            x.right = put(key, value, x.right);
        }
        // refresh the state of x, return the puted x.
        x.N = size(x.left) + size(x.right) + 1;

        return x;

    }

    /** Return all the keys in a set */
    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<K>();
        keySet(keys, root);
        return keys;
    }

    private void keySet(Set<K> keys, Node x) {
        if (x == null) {
            return;
        }

        // add all the keys in the left subtree
        keySet(keys, x.left);

        // add x
        keys.add(x.key);

        // add all the keys in the right subtree
        keySet(keys, x.right);
    }



    @Override
    public V remove(K key) {
        // Get the value of key
        V value = get(key);

        // remove the key
        root = remove(key, root);

        // return the value
        return value;
    }

    private Node remove(K key, Node x) {
        // if x is an empty tree, just return null
        if (x == null) {
            return null;
        }

        // Go to the position of key
            // key is in the left subtree of x
            // key is in the right subtree of x
        // remove a single key
        int comp = key.compareTo(x.key);
        if (comp < 0) {
            x.left = remove(key, x.left);
        } else if (comp > 0) {
            x.right = remove(key, x.right);
        } else {
            // x's right/left link is null
            if (x.left == null) {
                return x.right;
            } else if (x.right == null) {
                return x.left;
            } else {
                // x's right/left link is all not null
                // set a link to the deleted link
                // set a link to x's successor
                // change x's link to deleteMin(x)
                // change x's left link to deleted link.left
                Node t = x;

                // For test:
                x = min(x.right);
                x.right = deleteMin(x);
                x.left = t.left;
            }
        }

        // Refresh and return
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    /** Return the min key in the tree */
    public K min() {
        return min(root).key;
    }

    /** Return the min key in the tree which starts at x */
    private Node min(Node x) {
        // Error checking -- for empty tree
        if (x == null) {
            return null;
        }

        // base case: x.left is null
        if (x.left == null) {
            return x;
        }

        return min(x.left);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /** Delete the min key in a tree */
    public void deleteMin() {
        root = deleteMin(root);
    }
    /** Delete the min key in the tree which start with x */
    private Node deleteMin(Node x) {
        if (x == null) {
            return null;
        }

        // base case: x.left is null
        if (x.left == null) {
            return x.right;
        } else {
            // recursive case
            x = deleteMin(x.left);
        }

        // refresh the size and return
        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }

    @Override
    public V remove(K key, V value) {
        return null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<K> iterator() {
        return null;
    }

    /** prints out your BSTMap in order of increasing Key */
    public void printInOrder() {
        printInOder(root);
    }

    /** Helper function: to print the tree starts at x */
    private void printInOder(Node x) {
        if (x == null) {
            // do nothing
            return;
        }

        // print the left subtree.
        printInOder(x.left);

        // print the x
        System.out.print(x.key + ": " + x.value + " ");

        // print the right subtree
        printInOder(x.right);
    }


}
