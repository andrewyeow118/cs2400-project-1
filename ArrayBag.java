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



    public int getCurrentSize(){
        return numberOfEntries;
    }

    public boolean isEmpty(){
        return numberOfEntries == 0;
    }

    public boolean add(T newEntry){
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
}
