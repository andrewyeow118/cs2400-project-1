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

    /*public T[] union(T[] bag2)
    {
        int length = numberOfEntries + bag2.length;
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[length];
        for (int i = 0 ; i < length ; i++)
        {
            result[i] 
        }
    }*/
}