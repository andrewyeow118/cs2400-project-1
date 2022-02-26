public class ResizableArrayBag<T> implements BagInterface<T> 
{
    private final T[] bag;
    private static final int defaultCapacity = 25;
    private int numberOfEntries;
    
    public ResizableArrayBag()
    {
        this(defaultCapacity);
    }

    public ResizableArrayBag(int capacity)
    {
        numberOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[capacity];
        bag = tempBag;
    }

    public int getCurrentSize()
    {
        return numberOfEntries;
    }

	public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }

	public boolean add(T newEntry)
    {
        if (numberOfEntries == defaultCapacity)
            return false;
        else
        {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
            return true;
        }
    }

    private T removeEntry(int givenIndex)
    {
        T result = null;
        if (!isEmpty() && givenIndex >= 0)
        {
            result = bag[givenIndex];
            bag[givenIndex] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
        }
        return result;
    }

    private int getIndexOf(T anEntry)
    {
        for (int i = 0 ; i < numberOfEntries ; i++)
        {
            if (anEntry.equals(bag[i]))
            {
                return i;
            }
        }
        return -1;
    }

	public T remove()
    {
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }

    public boolean remove(T anEntry)
    {
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return result.equals(anEntry);
    }

	public void clear()
    {
        while (!isEmpty())
            remove();
    }

	public int getFrequencyOf(T anEntry)
    {
        int count = 0;
        for (int i = 0 ; i < numberOfEntries ; i++)
        {
            if (bag[i].equals(anEntry))
            {
                count++;
            }
        }
        return count;
    }

	public boolean contains(T anEntry)
    {
        int index = getIndexOf(anEntry);
        return index != -1;
    }
   
	public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        for (int i = 0 ; i < numberOfEntries ; i++)
        {
            result[i] = bag[i];
        }
        return result;
    }

    public T getValue(int index){
        return this.bag[index];
    }

    public BagInterface<T> copyOf(BagInterface<T> bag2){
        BagInterface<T> returnBag = new ResizableArrayBag<>();
        for(int i= 0; i < bag2.getCurrentSize(); i++){
            returnBag.add(bag2.getValue(i));
        }
        return returnBag;
    }

    /** this method returns an ArrayBag that contains the contents that are common 
     * to both the ArrayBag that the method is being called on and the ArrryBag that is in 
     * the method argument 
     * @param bag2 an Arraybag to be compared with the Arraybag that the method is being called on
     * @return an array that contains the intersection between the two ArrayBags
     */
    public BagInterface<T> intersection(BagInterface<T> bag2) throws Exception{
        //sanitize user input
        for(int i = 0; i < bag2.getCurrentSize(); i++){
            if(bag2.getValue(i) == null){
                throw new Exception("bag2 contains a null value");
            }
        }
        //copy bag2 
        BagInterface<T> bag2Copy = copyOf(bag2);
        //intialize return bag 
        BagInterface<T> bag3 = new ResizableArrayBag<>();
        //loop thru bag1
        for(int i = 0; i < this.getCurrentSize(); i++){
            //loop thru bag2copy
            for(int j = 0; j < bag2Copy.getCurrentSize(); j++){
                //check for common elements
                if(this.bag[i] == bag2Copy.getValue(j)){
                    //add common element to return bag
                    bag3.add(this.bag[i]);
                    //remove checked element from bag2Copy
                    bag2Copy.remove(bag2Copy.getValue(j));
                }
            }
        }
        //return the return bag
        return bag3;
    }

}