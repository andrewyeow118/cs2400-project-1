import java.util.Arrays;
public class ResizableArrayBag<T> implements BagInterface<T> 
{
    private T[] bag;
    private static final int defaultCapacity = 25;
    private int numberOfEntries;
    private boolean integrityOK = false;
    private static final int MAX_CAPACITY = 10000;
    
    public ResizableArrayBag()
    {
        this(defaultCapacity);
    }

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
        numberOfEntries--;
        return result;
    }

    public boolean remove(T anEntry)
    {
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        numberOfEntries--;
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
            System.out.print(result[i]);
        }
        return result;
    }

    public T getEntry(int index)
    {
        return bag[index];
    }


    public BagInterface<T> union(BagInterface<T> bag2) 
    {
        BagInterface<T> result = new ResizableArrayBag<>();
        for (int i = 0 ; i < numberOfEntries ; i++)
            result.add(bag[i]);
        for (int j = 0 ; j < bag2.getCurrentSize() ; j++)
            result.add(bag2.getEntry(j));
        return result;
    }

    public BagInterface<T> intersection(BagInterface<T> bag2)
    {
        BagInterface<T> result = new ResizableArrayBag<>();
        for (int i = 0 ; i < numberOfEntries ; i++)
        {
            for (int j = 0 ; j < bag2.getCurrentSize() ; j++)
            {
                if (this.getEntry(i).equals(bag2.getEntry(j)))
                {
                    result.add(this.getEntry(i));
                    bag2.remove(bag2.getEntry(j));
                }
            }
        }
        return result;
    }
}