public class LinkedListDeque<Item> {

	private class StuffNode {
		public Item item;
		public StuffNode prev;
		public StuffNode next;

		public StuffNode(StuffNode p, Item i, StuffNode n) {
			item = i;
			prev = p;
			next = n;
		}
	}

	private int size;
	private StuffNode sentinel;


	/** No args ctor.*/
	public LinkedListDeque() {

		sentinel.next = sentinel;
	}

	/** Adds an item to the front of the Deque. */
	public void addFirst(Item i) {

		if(sentinel.next != sentinel) {
			StuffNode p = sentinel.next;
			sentinel.next = new StuffNode(sentinel, i, p);
		} else
		sentinel.next = new StuffNode(sentinel, i, null);
		size += 1;
	}

	/** Adds an item to the back of the Deque. */
	public void addLast(Item i) {
		size += 1;

		StuffNode p = sentinel;

		while (p.next != sentinel) {
			p = p.next;
		}

		p.next = new StuffNode(p, i, sentinel);
	}

	/** Returns true if deque is empty, false otherwise. */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Returns the number of items in the Deque. */
	public int size() {
		return size;
	}

	/** Prints the items in the Deque from first to last, separated by a 
	space. */
	public void printDeque() {

	}

	/** Removes and returns the item at the front of the Deque. If no such 
	item exists, returns null. */
	public void removeFirst() {

	}

	/** Removes and returns the item at the back of the Deque. If no such 
	item exists, returns null.*/
	public void removeLast() {

	}

	/** Gets the item at the given index, where 0 is the front, 1 is the next 
	item, and so forth. If no such item exists, returns null. Must not alter 
	the deque!*/
	public Item get(int index) {

	}

	/** Gets the item at the given index using recursion, where 0 is the front, 
	1 is the next item, and so forth. If no such item exists, returns null. 
	Must not alter the deque!*/
	public Item getRecursive(int index) {

	}

}