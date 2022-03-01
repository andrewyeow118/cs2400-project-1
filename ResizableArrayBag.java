import java.util.Arrays;
public class ResizableArrayBag<T> implements BagInterface<T> 
{
    private T[] bag; //cannot be final since it is resizable array bag
    private static final int defaultCapacity = 25;
    private int numberOfEntries;
    private boolean integrityOK = false;
    private static final int MAX_CAPACITY = 10000;
    
    //default constructor (no given capacity)
    public ResizableArrayBag()
    {
        this(defaultCapacity);
    }

    //constructor with given capacity
    public ResizableArrayBag(int capacity)
    {
        if (capacity <= MAX_CAPACITY)
        {
            numberOfEntries = 0;
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[])new Object[capacity];
            bag = tempBag;
            integrityOK = true;
        }
        else
            throw new IllegalStateException("Attempt to create a bag whose" 
            +  "capacity exceeds allowed maximum.");
    }

    private void checkIntegrity()
    {
        if (!integrityOK)
            throw new SecurityException("ArrayBag object is corrupt.");
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
        checkIntegrity();
        if (numberOfEntries == defaultCapacity)
        {
            bag = Arrays.copyOf(bag, 2 * bag.length);
            
        }
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
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
                count++;
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
            result[i] = this.getEntry(i);
        }
        return result;
    }

    //returns entry at given index
    public T getEntry(int index)
    {
        return bag[index];
    }

    //modified remove method specifically for difference method
    public boolean differenceRemove(T anEntry)
    {
        //removes entry at given position without replacing or decreasing numberOfEntries
        int index = getIndexOf(anEntry);
        bag[index] = null;
        return true;
    }

    public BagInterface<T> union(BagInterface<T> bag2) 
    {
        /*  union method: returns all the items of two bags in one bag ;
         *  bag1 and bag2 do not need to be cloned because we are just getting
         *  their values and adding to the returned bag */
        BagInterface<T> result = new ResizableArrayBag<>();
        for (int i = 0 ; i < numberOfEntries ; i++)
            result.add(bag[i]);
        for (int j = 0 ; j < bag2.getCurrentSize() ; j++)
            result.add(((ResizableArrayBag<T>) bag2).getEntry(j));
        return result;
    }

    public BagInterface<T> intersection(BagInterface<T> bag2)
    {
        /*  intersection method: returns the common items of two bags in one bag ;
         *  bag1 and bag2 are cloned because we must remove their common items
         *  and add the leftovers from bag1 */

        BagInterface<T> result = new ResizableArrayBag<>(); 
        BagInterface<T> bag1Clone = this;
        BagInterface<T> bag2Clone = bag2;
        for (int i = 0 ; i < bag1Clone.getCurrentSize() ; i++)
        {
            for (int j = 0 ; j < bag2Clone.getCurrentSize() ; j++)
            {
                if (((ResizableArrayBag<T>) bag1Clone).getEntry(i).equals(((ResizableArrayBag<T>) bag2Clone).getEntry(j)))
                {
                    result.add(((ResizableArrayBag<T>) bag1Clone).getEntry(i));
                    bag2Clone.remove(((ResizableArrayBag<T>) bag2Clone).getEntry(j));
                    break;
                }
            }
        }
        return result;
    }

    public BagInterface<T> difference(BagInterface<T> bag2)
    {
        /*  eric - difference method: returns the difference of bag calling the method 
         *  with bag passed as paramter all in one bag ;
         *  bag1 and bag2 are cloned because we must remove their common items
         *  and add the leftovers from bag1 */
        BagInterface<T> result = new ResizableArrayBag<>();
        BagInterface<T> bag1Clone = this;
        BagInterface<T> bag2Clone = bag2;
        for (int i = 0 ; i < bag1Clone.getCurrentSize() ; i++)
        {
            for (int j = 0 ; j < bag2Clone.getCurrentSize() ; j++)
            {
                if (((ResizableArrayBag<T>) bag1Clone).getEntry(i).equals(((ResizableArrayBag<T>) bag2Clone).getEntry(j)))
                {
                    ((ResizableArrayBag<T>) bag1Clone).differenceRemove(((ResizableArrayBag<T>) bag1Clone).getEntry(i));
                    bag2Clone.remove(((ResizableArrayBag<T>) bag2Clone).getEntry(j));
                    break;
                }
            }
        }
        for (int i = 0 ; i < bag1Clone.getCurrentSize() ; i++)
        {
            if (((ResizableArrayBag<T>) bag1Clone).getEntry(i) != null)
                result.add(((ResizableArrayBag<T>) bag1Clone).getEntry(i));
        }
        return result;
    }
}