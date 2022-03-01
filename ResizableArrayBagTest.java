public class ResizableArrayBagTest 
{
    public static void main(String[] args)
    {
        testGetCurrentSize();
        testIsEmpty();
        testAdd();
        testRemove();
        testRemoveEntry();
        testClear();
        testGetFrequencyOf();
        testContains();
    }

    public static void testGetCurrentSize()
    {
        ResizableArrayBag<Integer> bag1 = new ResizableArrayBag<>();
        ResizableArrayBag<Integer> bag2 = new ResizableArrayBag<>();
        int[] bag1arr = {2, 3, 4, 5};
        int[] bag2arr = {};
        for (int i = 0 ; i < bag1arr.length ; i++)
            bag1.add(bag1arr[i]);
        for (int i = 0 ; i < bag2arr.length ; i++)
            bag2.add(bag2arr[i]);
        System.out.print(bag1.getCurrentSize() == 4); //output should be true
        System.out.print(bag2.getCurrentSize() == 0); //output should be true
        System.out.print(bag1.getCurrentSize() == 5); //output should be false
        System.out.print(bag1.getCurrentSize() == 5); //output should be false
    }

    public static void testIsEmpty()
    {
        ResizableArrayBag<Integer> bag1 = new ResizableArrayBag<>();
        ResizableArrayBag<Integer> bag2 = new ResizableArrayBag<>();
        int[] bag1arr = {2, 3, 4, 5};
        int[] bag2arr = {};
        for (int i = 0 ; i < bag1arr.length ; i++)
            bag1.add(bag1arr[i]);
        for (int i = 0 ; i < bag2arr.length ; i++)
            bag2.add(bag2arr[i]);
        System.out.println("\n");
        System.out.print(bag1.isEmpty() == false); //output should be true
        System.out.print(bag2.isEmpty() == true); //output should be true
        System.out.print(bag1.isEmpty() == true); //output should be false
        System.out.print(bag2.isEmpty() == false); //output should be false
    }

    public static void testAdd()
    {
        ResizableArrayBag<Integer> bag1 = new ResizableArrayBag<>();
        ResizableArrayBag<Integer> bag2 = new ResizableArrayBag<>();
        int[] bag1arr = {2, 3, 4, 5};
        int[] bag2arr = {1};
        for (int i = 0 ; i < bag1arr.length ; i++)
            bag1.add(bag1arr[i]);
        for (int i = 0 ; i < bag2arr.length ; i++)
            bag2.add(bag2arr[i]);
        System.out.println("\n");
        System.out.print(bag1.contains(2) == true); //output should be true
        System.out.print(bag2.contains(1) == true); //output should be true
        System.out.print(bag1.contains(1) == true); //output should be false
        System.out.print(bag2.contains(2) == true); //output should be false
    }

    public static void testRemove()
    {
        ResizableArrayBag<Integer> bag1 = new ResizableArrayBag<>();
        ResizableArrayBag<Integer> bag2 = new ResizableArrayBag<>();
        int[] bag1arr = {2, 3, 4, 5};
        int[] bag2arr = {1};
        for (int i = 0 ; i < bag1arr.length ; i++)
            bag1.add(bag1arr[i]);
        for (int i = 0 ; i < bag2arr.length ; i++)
            bag2.add(bag2arr[i]);
        bag1.remove();
        bag2.remove();
        System.out.println("\n");
        System.out.print(!(bag1.contains(5)) == true); //output should be true
        System.out.print(bag2.isEmpty() == true); //output should be true
        System.out.print(bag1.contains(5) == true); //output should be false
        System.out.print(bag2.contains(1) == true); //output should be false
    }

    public static void testRemoveEntry()
    {
        ResizableArrayBag<Integer> bag1 = new ResizableArrayBag<>();
        ResizableArrayBag<Integer> bag2 = new ResizableArrayBag<>();
        int[] bag1arr = {2, 3, 4, 5};
        int[] bag2arr = {1};
        for (int i = 0 ; i < bag1arr.length ; i++)
            bag1.add(bag1arr[i]);
        for (int i = 0 ; i < bag2arr.length ; i++)
            bag2.add(bag2arr[i]);
        bag1.remove(2);
        bag2.remove(1);
        System.out.println("\n");
        System.out.print(!(bag1.contains(2)) == true); //output should be true
        System.out.print(bag2.isEmpty() == true); //output should be true
        System.out.print(bag1.contains(2) == true); //output should be false
        System.out.print(bag2.contains(1) == true); //output should be false
    }

    public static void testClear()
    {
        ResizableArrayBag<Integer> bag1 = new ResizableArrayBag<>();
        ResizableArrayBag<Integer> bag2 = new ResizableArrayBag<>();
        int[] bag1arr = {2, 3, 4, 5};
        int[] bag2arr = {1};
        for (int i = 0 ; i < bag1arr.length ; i++)
            bag1.add(bag1arr[i]);
        for (int i = 0 ; i < bag2arr.length ; i++)
            bag2.add(bag2arr[i]);
        bag1.clear();
        bag2.clear();
        System.out.println("\n");
        System.out.print(bag1.isEmpty() == true); //output should be true
        System.out.print(bag2.isEmpty() == true); //output should be true
        System.out.print(bag1.contains(1) == true); //output should be false
        System.out.print(bag2.contains(1) == true); //output should be false
    }

    public static void testGetFrequencyOf()
    {
        ResizableArrayBag<Integer> bag1 = new ResizableArrayBag<>();
        int[] bag1arr = {2, 3, 4, 5, 2, 3, 3};
        for (int i = 0 ; i < bag1arr.length ; i++)
            bag1.add(bag1arr[i]);
        System.out.println("\n");
        System.out.print(bag1.getFrequencyOf(2) == 2); //output should be true
        System.out.print(bag1.getFrequencyOf(3) == 3); //output should be true
        System.out.print(bag1.getFrequencyOf(2) == 1); //output should be false
        System.out.print(bag1.getFrequencyOf(3) == 5); //output should be false
    }

    public static void testContains()
    {
        ResizableArrayBag<Integer> bag1 = new ResizableArrayBag<>();
        int[] bag1arr = {2, 3, 4, 5, 2, 10, 3};
        for (int i = 0 ; i < bag1arr.length ; i++)
            bag1.add(bag1arr[i]);
        System.out.println("\n");
        System.out.print(bag1.contains(2) == true); //output should be true
        System.out.print(bag1.contains(10) == true); //output should be true
        System.out.print(bag1.contains(11) == true); //output should be false
        System.out.print(bag1.contains(0) == true); //output should be false
    }

    public static void testUnion()
    {

    }

    public static void testIntersection()
    {
        
    }

    public static void testDifference()
    {
        
    }
}