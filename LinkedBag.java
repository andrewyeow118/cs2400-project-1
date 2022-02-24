public class LinkedBag<T> implements BagInterface<T> {
	
	private Node firstNode;
	private int numberOfEntries;
	
	public LinkedBag() {
		firstNode = null;
		numberOfEntries = 0;
	}
	
	public boolean add(T newEntry) {
		
	}
	
	/**
	 * 
	 * @author dylan
	 *
	 */
	private class Node
	{
		private T data;
		private Node next;
		
		/**
		 * Used to construct first Node
		 * @param dataLink: piece of data stored in initial Node
		 */
		private Node (T dataPiece) {
			this(dataPiece, null);
		}
		
		/**
		 * Sets portion of data held in this Node, and the pointer to the next
		 * @param sets a reference to a peice of data
		 * @param points to next linked Node
		 */
		private Node(T dataPiece, Node next) {
			data = dataPiece;
			this.next = next;
		}
		
		/**
		 * returns data stored in Node
		 */
		private T getData() {
			return data;
		}
		
		/**
		 * changes the data stored in this node
		 * @param new data
		 */
		private void setData(T newData) {
			data = newData;
		}
		
		/**
		 * returns the linked Node object
		 */
		private Node getNextNode() {
			return next;
		}
		
		/**
		 * changes the linked node referenced by "next"
		 * @param sets the node that this one points to
		 */
		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
		
	}
}