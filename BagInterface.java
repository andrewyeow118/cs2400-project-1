public interface BagInterface<T> {

    public int getCurrentSize();
    public boolean isEmpty();
    public boolean add(T newEntry);
    public T remove();
    public boolean remove(T anEntry);
    public void clear();
    public int getFrequencyOf(T anEntry);
    public boolean contains(T anEntry);
    public T[] toArray();

    
    
    /** this method returns a BagInterface<T> that contains the contents that are common 
     * to both the BagInterface<T> that the method is being called on and the BagInterface<T> that is in 
     * the method argument 
     * @param bag2 an BagInterface<T> to be compared with the BagInterface<T> that the method is being called on
     * @return a BagInterface<T> that contains the intersection between the two BagInterface<T>s
     */
    public BagInterface<T> intersection(BagInterface<T> bag2) throws Exception;

    /** this method returns an BagInterface<T> that contains the contents of bag recieving the
     * call to the method and the BagInterface<T> that is the methods's argument 
     * @param bag2 an BagInterface<T> to be combined with the BagInterface<T> that the method is being called on
     * @return an array that contains the union between the two BagInterface<T>s
     */
    public BagInterface<T> union(BagInterface<T> bag2) throws Exception;

    /** this method returns an BagInterface<T> that contains the contents that are not shared between 
     * the BagInterface<T> that the method is being called on and the BagInterface<T> in the methods argument
     * @param bag2 an BagInterface<T> to be compared with the BagInterface<T> that the method is called on
     * @return an array that contains the contents of the first BagInterface<T> that the second BagInterface<T> 
     * does not contain
     */
    public BagInterface<T> difference(BagInterface<T> bag2) throws Exception;

   
}