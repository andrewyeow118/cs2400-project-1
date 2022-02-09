public interface BagInterface<T> {

    public int getCurrentSize();
    public boolean isEmpty();
    public boolean add(T newEntry);
    //public T remove();
    //public boolean remove(T anEntry);
    //public void clear();
    //public int getFrequencyOf(T anEntry);
    //public boolean contain(T anEntry);
    //public T[] toArray();
    
    /** this method returns an array that contains the contents that are common 
     * to both the ArrayBag that the method is being called on and the ArrryBag that is in 
     * the method argument 
     * @param x an Arraybag to be compared with the Arraybag that the method is being called on
     * @return an array that contains the intersection between the two ArrayBags
     */
    //public T[] intersection(BagInterface<T> x);

    /** this method returns an array that contains the contents of bag recieving the
     * call to the method and the bag that is the methods's argument 
     * @param x an ArrayBag to be combined with the ArrayBag that the method is being called on
     * @return an array that contains the union between the two ArrayBags
     */
    //public T[] union(BagInterface<T> x);

    /** this method returns an array that contains the contents that are not shared between 
     * the ArrayBag that the method is being called on and the ArrayBag in the methods argument
     * @param x an Arraybag to be compared with the ArrayBag that the method is called on
     * @return an array that contains the difference between the two ArrayBags
     */
    //public T[] difference(BagInterface<T> x);

   
}
