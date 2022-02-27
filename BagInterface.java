/**
   An interface that describes the operations of a bag of objects.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public interface BagInterface<T>
{
	/** Gets the current number of entries in this bag.
		 @return  The integer number of entries currently in the bag. */
	public int getCurrentSize();
	
	/** Sees whether this bag is empty.
		 @return  True if the bag is empty, or false if not. */
	public boolean isEmpty();
	
	/** Adds a new entry to this bag.
	    @param bag  The object to be added as a new entry.
	    @return  True if the addition is successful, or false if not. */
	public boolean add(T bag);

	/** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal.
                was successful, or null. */
	public T remove();
   
	/** Removes one occurrence of a given entry from this bag, if possible.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false if not. */
   public boolean remove(T anEntry);
	
	/** Removes all entries from this bag. */
	public void clear();
	
	/** Counts the number of times a given entry appears in this bag.
		 @param anEntry  The entry to be counted.
		 @return  The number of times anEntry appears in the bag. */
	public int getFrequencyOf(T anEntry);
	
	/** Tests whether this bag contains a given entry.
		 @param anEntry  The entry to find.
		 @return  True if the bag contains anEntry, or false if not. */
	public boolean contains(T anEntry);
   
	/** Retrieves all entries that are in this bag.
		 @return  A newly allocated array of all the entries in the bag.
                Note: If the bag is empty, the returned array is empty. */
	public T[] toArray();

	//Returns an entry based on given index
	public T getEntry(int index);

	//modified remove method for difference method
	//removes an entry without replacing or decreasing numberOfEntries
	public boolean differenceRemove(T anEntry);

	//union method ; combines all the contents of the two bags and returns them in one bag
	public BagInterface<T> union(BagInterface<T> bag2);

	//intersection method ; takes the common items of the two bags and returns them in one bag
	public BagInterface<T> intersection(BagInterface<T> bag2);

	/*difference method ; subtracts the contents of the bag passed as a parameter 
	from the bag that is calling the method*/
	public BagInterface<T> difference(BagInterface<T> bag2);

} // end BagInterface