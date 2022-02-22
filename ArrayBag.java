public class ArrayBag<T> implements BagInterface<T> {
    private final T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;
    private static boolean integrityOK = false;
    private static final int MAX_CAPACITY = 1000;

    public ArrayBag(int capacity){
        if(capacity <= MAX_CAPACITY){

            @SuppressWarnings("unchecked")
            T[] tempBag = (T[])new Object[capacity];
            bag = tempBag;
            numberOfEntries = 0;
            integrityOK = true;
        }else{
            throw new IllegalArgumentException("attempted to create a bag whose" + "capacity exceeded the maximum");
        }
    }

    private void checkIntegrity(){
        if(!integrityOK){
            throw new SecurityException("Arraybag object is corupt.");
        }
    }

    public T[] getBag(){
        return bag;
    }

    public int getCurrentSize(){
        return numberOfEntries;
    }

    public boolean isEmpty(){
        return numberOfEntries == 0;
    }

    public boolean add(T newEntry){
        checkIntegrity();
        boolean result = true;
        if(isFull()){
            return false;
        }
        else{
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
    }

    public boolean isFull(){
        return numberOfEntries == bag.length;
    }

    /** this method returns an array that contains the contents of bag recieving the
     * call to the method and the bag that is the methods's argument 
     * @param x an ArrayBag to be combined with the ArrayBag that the method is being called on
     * @return an array that contains the union between the two ArrayBags
     */
    public T[] union(BagInterface<T> x){
        T[] returnArray;
        int counter = 0;
        for(int i = 0; i < this.getCurrentSize(); i++){
            returnArray[i] = this.getBag()[i];
            counter++;
        }
        for(int i = counter; i < x.getCurrentSize() + counter; i++){
            returnArray[i] = x.getBag()[i];
        }
        return returnArray;
        
        
    }
}
