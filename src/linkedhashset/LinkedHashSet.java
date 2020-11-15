package linkedhashset;

public class LinkedHashSet implements Set {
	
	private class Node {
		/**
		 * @invar | (element == null) == (this == sentinel)  
		 * @invar | previous != null
		 * @invar | next.previous == this
		 * @invar | previous.next == this
		 * 
		 * @peerObject
		 */
		private Node previous;
		private Object element;
		/** @peerObject */
		private Node next;
		
		//private int getLength() { return this == sentinel ? 0 : 1; }
	}
	
	/**
	 * @invar | sentinel != null
	 * @invar | size >= 0
	 */
	private int size;
	/** @representationObject */
	private Node sentinel;
// not needed since objects will only be added to end of list	
//	private Node getNode(int index) {
//		Node node = sentinel;
//		if (index <= size / 2)
//			for (; index >= 0; index--)
//				node = node.next;
//		else
//			for (; index < size; index++)
//				node = node.previous;
//		return node;
//	}
	
	
	public LinkedHashSet() {
		sentinel = new Node();
		sentinel.previous = sentinel;
		sentinel.next = sentinel;
	}
	HashMap map = new HashMap(20);
	
	
	@Override
	// not possible in constant time
	public Object[] toArray() {
		Object[] result = new Object[size];
		int i = 0;
		for (Node node = sentinel.next; node != null; node = node.next)
			result[i++] = node.element;
		return result;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean contains(Object value) {
		return map.contains(value);
	}

	@Override
	public void add(Object value) {
		Node node = new Node();
		node.element = value;
		node.next = null;
		node.previous = sentinel.previous;
		sentinel.previous = node;
		node.previous.next = node;
		size++;
		map.put(value, node);
	}


	@Override
	public void remove(Object object) {
		Node node = (Node) map.get(object);

		if (node.previous == null) {
			node.next.previous = null;
			sentinel.next = node.next;
		} else if (node.next == null) {
			node.previous.next = null;
			sentinel.previous = node.previous;
		} else {
			node.previous.next = node.next;
			node.next.previous = node.previous;
			// node will be deleted by garbage collector
		}
		size--;
		map.remove(object);
	}


}
