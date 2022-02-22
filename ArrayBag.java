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
            throw new SecurityException("ArrayBag object is corrupt.");
        }
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

    public int getFrequencyOf(T anEntry){
        checkIntegrity();
        int counter = 0;

        for(int i = 0; i < bag.length; i++){
            if(anEntry.equals(bag[i])){
                counter++;
            }
        }
        return counter;
    }

    public T remove(){
        checkIntegrity();
        T result = removeEntry(numberOfEntries -1);
        return result;
    }

    public boolean remove(T anEntry){
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
        
    }

    private int getIndexOf(T anEntry){
        int where = -1;
        boolean found = false;
        int index = 0;

        while (!found && (index < numberOfEntries)){
            if (anEntry.equals(bag[index])){
                found = true;
                where = index;
            }
        index++;
        } 

        return where;
    }

    private T removeEntry(int givenIndex){
		T result = null;
      
		if (!isEmpty() && (givenIndex >= 0)){
            result = bag[givenIndex];                   
            bag[givenIndex] = bag[numberOfEntries - 1]; 
            bag[numberOfEntries - 1] = null;           
            numberOfEntries--;
		} 
        return result;
    } 

    public void clear(){
        while(!isEmpty()){
            remove();
        }
    }

    public boolean contains(T anEntry){
        checkIntegrity();
        return getIndexOf(anEntry) > -1;
    }

    public boolean isFull(){
        return numberOfEntries == bag.length;
    }

    public T[] toArray(){
        return bag;
    }
}
