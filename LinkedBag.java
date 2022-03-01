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
	
	/** this method returns a LinkedBag that contains the contents that are common 
     * to both the LinkedBag that the method is being called on and the LinkedBag that is in 
     * the method argument 
     * @param bag2 a Linkedbag to be compared with the Linkedbag that the method is being called on
     * @return a LinkedBag that contains the intersection between the two LinkedBags
     */
	public BagInterface<T> intersection(BagInterface<T> bag2) throws Exception {
		checkIntegrity();
		
		//sanitize user input
		if (bag2 == null)
			throw new Exception("The given argument is null");
			
		//new intersection bag
		BagInterface<T> bag3 = new LinkedBag();
		
		//copy of this bag
		BagInterface<T> bag1Copy = copyOf(this);
		
		//copy of inputted bag
		BagInterface<T> bag2Copy = copyOf(bag2);
		
		//adds the intersection of bag 1 & bag 2 to bag3
		while(!bag2Copy.isEmpty()) {
			T temp = bag2Copy.remove;
			if (bag1Copy.contains(temp)) {
				bag3.add(temp);
				bag1Copy.remove(temp);
			}
		}
		
		return bag3;
	}
	
	/** this method returns a LinkedBag that contains the contents of bag recieving the
     * call to the method and the bag that is the methods's argument 
     * @param bag2 a LinkedBag to be combined with the LinkedBag that the method is being called on
     * @return a LinkedBag that contains the union between the two LinkedBags
     */
    public BagInterface<T> union(BagInterface<T> bag2) {
    	
    	//sanitize user input
    	if (bag2 == null)
    		throw new Exception("The given argument is null");
    				
    	//new union bag
    	BagInterface<T> bag3 = new LinkedBag();
    			
    	//copy of this bag
    	BagInterface<T> bag1Copy = copyOf(this);
    			
    	//copy of inputted bag
    	BagInterface<T> bag2Copy = copyOf(bag2);
    	
    	//Add contents of this bag to bag3
    	while(!bag1Copy.isEmpty()) {
    		bag3.add(bag1Copy.remove());
    	}
    	
    	//Add contents of argument bag to bag3
    	while(!bag2Copy.isEmpty()) {
    		bag3.add(bag2Copy.remove());
    	}
    	
    	return bag3;
    }
    
    /** this method returns a LinkedBag that contains the contents that are not shared between 
     * the LinkedBag that the method is being called on and the LinkedBag in the methods argument
     * @param bag2 a Linkedbag to be compared with the LinkedBag that the method is called on
     * @return a LinkedBag that contains the contents of the first LinkedBag that the second Linkedbag 
     * does not contain
     */
    public BagInterface<T> difference(BagInterface<T> bag2) {
    	
    	//sanitize user input
    	if (bag2 == null)
    		throw new Exception("The given argument is null");
    				
    	//new intersection bag
    	BagInterface<T> bag3 = new LinkedBag();
    	
    	//copy of this bag
    	BagInterface<T> bag1Copy = copyOf(this);
    	
    	//copy of inputted bag
    	BagInterface<T> bag2Copy = copyOf(bag2);
    	
    	//Removes every element from bag2, and if that element exists in bag 1, removes it as well
    	while(!bag2Copy.isEmpty()) {
    		T temp = bag2Copy.remove();
    		if (bag1Copy.contains(temp))
    			bag1Copy.remove(temp);		
    	}
    	
    	//sets bag3 equal to the remaining contents of the copy of bag1
    	bag3 = bag1Copy;
    	
    	return bag3;
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