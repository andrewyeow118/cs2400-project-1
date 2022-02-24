/**
 * 
 * @author Dylan
 *
 * @param <T>
 */
public class LinkedBag<T> implements BagInterface<T> {
	
	private Node firstNode;
	private int numberOfEntries;
	private static boolean integrityOK = false;
	
	public LinkedBag() {
		firstNode = null;
		numberOfEntries = 0;
		integrityOK = true;
	}
	
	private void checkIntegrity(){
	    if(!integrityOK){
	        throw new SecurityException("LinkedBag object is corrupt.");
	    }
	}
	
	/**
	 * shows size of bag
	 * @return number of entries currently stored in the bag
	 */
	public int getCurrentSize(){
        return numberOfEntries;
    }

	/**
	 * shows whether bag is empty or not
	 * @return true if firstNode is null
	 */
    public boolean isEmpty(){
        return firstNode = null;
    }
	
	/**
	 * Creates a new node in the 1st position and has it point to the old 1st Node
	 * @param newEntry
	 * @return true if successful
	 */
	public boolean add(T newEntry) {
		checkIntegrity();
		
		Node newNode = new Node(newEntry);
		newNode.setNextNode(firstNode);
		firstNode = newNode;
		numberOfEntries++;
		return true;
	}
	
	/**
	 * Removes the first node in the linked chain, and sets the second node to 1st
	 * @return the removed data
	 */
	public T remove( ) {
		checkIntegrity();
		
		T result = null;
		if (firstNode != null) {
			result = firstNode.getData();
			firstNode = firstNode.getNextNode();
			numberOfEntries--;
		}
		return result;
	}
	
	/**
	 * retrieves reference to Node containing specified data, or null if data is missing
	 * @param anEntry object to search for
	 * @return reference to Node containg specified object
	 */
	public Node getReferenceTo(T anEntry) {
		checkIntegrity();
		
		boolean found = false;
		Node currentNode = firstNode;
		
		while (!found && (currentNode == null)) {
			if(anEntry.equals(currentNode.getData()))
				found=true;
			else
				currentNode = currentNode.getNextNode();
		}
		return currentNode;
	}
	
	/**
	 * Removes the first Node in the chain containing the specified data, replaces it with data stored in first node, and erases the first node. Returns false if data does not exist in the bag.
	 * @param anEntry the object to be removed
	 * @return true if data was succesfully removed
	 */
	public boolean remove(T anEntry) {
		boolean result = false;
		Node targetNode = getReferenceTo(anEntry);
		
		if (targetNode != null) {
			targetNode.setData(firstNode.getData());
			firstNode = firstNode.getNextNode();
			
			numberOfEntries--;
			result = true;
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param anEntry returns if 
	 * @return
	 */
	public int getFrequencyOf(T anEntry) {
		checkIntegrity();
		
		int count = 0;
		Node currentNode = firstNode;
		while(currentNode != null) {
			if (anEntry.equals(currentNode.getData()))
				count++;
			currentNode = currentNode.getNextNode();
		}
		return count;
	}
	
	/**
	 * shows if a particular object exists in the Linked Bag
	 * @param anEntry the object that will be searched for
	 * @return true if the object "anEntry" exists in the bag's linked chain
	 */
	public boolean contains(T anEntry) {
		checkIntegrity();
		
		Node currentNode = firstNode;
		while(currentNode != null) {
			if (anEntry.equals(currentNode.getData()))
				return true;
			currentNode = currentNode.getNextNode();
		}
		return false;
	}
	
	/**
	 * Removes all nodes from the Linked Bag
	 */
	public void clear() {
		while (!isEmpty())
			remove();
	}
	
	/**
	 * Converts the data stored in the bag into a fixed array of that exact size and returns it.
	 * @return An unordered array of all the objects contained in the Linked Bag
	 */
	public T[] toArray() {
		checkIntegrity();
		
		Node currentNode = firstNode;
		T[] tempArray = new T[numberOfEntries];
		
		for (x = 0; x < numberOfEntries; x++) {
			tempArray[x] = currentNode.getData();
		}
		
		return tempArray;
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
		 * @param dataLink piece of data stored in initial Node
		 */
		private Node (T dataPiece) {
			this(dataPiece, null);
		}
		
		/**
		 * Sets portion of data held in this Node, and the pointer to the next
		 * @param dataPiece sets a reference to a peice of data
		 * @param next points to next linked Node
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
		 * @param newData new data
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
		 * @param nextNode sets the node that this one points to
		 */
		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
		
	}
}