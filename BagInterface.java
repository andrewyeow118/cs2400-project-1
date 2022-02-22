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
    
    /** this method returns an ArrayBag that contains the contents that are common 
     * to both the ArrayBag that the method is being called on and the ArrryBag that is in 
     * the method argument 
     * @param bag2 an Arraybag to be compared with the Arraybag that the method is being called on
     * @return an array that contains the intersection between the two ArrayBags
     */
    //public BagInterface<T> intersection(BagInterface<T> bag2);

    /** this method returns an ArrayBag that contains the contents of bag recieving the
     * call to the method and the bag that is the methods's argument 
     * @param bag2 an ArrayBag to be combined with the ArrayBag that the method is being called on
     * @return an array that contains the union between the two ArrayBags
     */
    //public BagInterface<T> union(BagInterface<T> bag2);

    /** this method returns an ArrayBag that contains the contents that are not shared between 
     * the ArrayBag that the method is being called on and the ArrayBag in the methods argument
     * @param bag2 an Arraybag to be compared with the ArrayBag that the method is called on
     * @return an array that contains the contents of the first ArrayBag that the second Arraybag 
     * does not contain
     */
    //public BagInterface<T> difference(BagInterface<T> bag2);

   
}
