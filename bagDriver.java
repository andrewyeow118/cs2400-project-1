public class bagDriver
{
    
    /** 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        //demos a typical usage of the three methods: union intersection, difference
        BagInterface<String> bag1 = new ResizableArrayBag<>();
        BagInterface<String> bag2 = new ResizableArrayBag<>();
        String[] bag1arr = {"a", "a", "b", "c", "c", "d", "e", "e", "z", "g"};
        String[] bag2arr = {"a", "b", "c", "c", "c", "d", "e", "f"};
        System.out.print("Bag1:  ");
        for (int i = 0 ; i < bag1arr.length ; i++)
        {
            bag1.add(bag1arr[i]);
            System.out.print(((ResizableArrayBag<String>) bag1).getEntry(i) + "  ");
        }
        System.out.print("\n\nBag2:  ");
        for (int i = 0 ; i < bag2arr.length ; i++)
        {
            bag2.add(bag2arr[i]);
            System.out.print(((ResizableArrayBag<String>) bag2).getEntry(i) + "  ");
        }
        unionDemo();
        intersectionDemo();
        differenceDemo();
    }

    
    /** 
     * @throws Exception
     */
    public static void unionDemo() throws Exception
    {
        BagInterface<String> bag1 = new ResizableArrayBag<>();
        BagInterface<String> bag2 = new ResizableArrayBag<>();
        String[] bag1arr = {"a", "a", "b", "c", "c", "d", "e", "e", "z", "g"};
        String[] bag2arr = {"a", "b", "c", "c", "c", "d", "e", "f"};
        for (int i = 0 ; i < bag1arr.length ; i++)
            bag1.add(bag1arr[i]);
        for (int i = 0 ; i < bag2arr.length ; i++)
            bag2.add(bag2arr[i]);
        BagInterface<String> everything = bag1.union(bag2);
        System.out.print("\n\nUnion:  ");
        for (int i = 0 ; i < everything.getCurrentSize() ; i++)
            System.out.print(((ResizableArrayBag<String>) everything).getEntry(i) + "  ");
        System.out.println("\n");
    }

    
    /** 
     * @throws Exception
     */
    public static void intersectionDemo() throws Exception
    {
        BagInterface<String> bag1 = new ResizableArrayBag<>();
        BagInterface<String> bag2 = new ResizableArrayBag<>();
        String[] bag1arr = {"a", "a", "b", "c", "c", "d", "e", "e", "z", "g"};
        String[] bag2arr = {"a", "b", "c", "c", "c", "d", "e", "f"};
        for (int i = 0 ; i < bag1arr.length ; i++)
            bag1.add(bag1arr[i]);
        for (int i = 0 ; i < bag2arr.length ; i++)
            bag2.add(bag2arr[i]);
        BagInterface<String> commonItems = bag1.intersection(bag2); //intersection should be  a, b, c, c, d, e
        System.out.print("Intersection:  ");
        for (int i = 0 ; i < commonItems.getCurrentSize() ; i++)
            System.out.print(((ResizableArrayBag<String>) commonItems).getEntry(i) + "  ");
        System.out.println("\n");
    }

    
    /** 
     * @throws Exception
     */
    public static void differenceDemo() throws Exception
    {
        BagInterface<String> bag1 = new ResizableArrayBag<>();
        BagInterface<String> bag2 = new ResizableArrayBag<>();
        String[] bag1arr = {"a", "a", "b", "c", "c", "d", "e", "e", "z", "g"};
        String[] bag2arr = {"a", "b", "c", "c", "c", "d", "e", "f"};
        for (int i = 0 ; i < bag1arr.length ; i++)
            bag1.add(bag1arr[i]);
        for (int i = 0 ; i < bag2arr.length ; i++)
            bag2.add(bag2arr[i]);
        BagInterface<String> leftOver1 = bag1.difference(bag2);  //difference should be  a, e, z, g
        System.out.print("Difference 1:  ");
        for (int i = 0 ; i < leftOver1.getCurrentSize() ; i++)
            System.out.print(((ResizableArrayBag<String>) leftOver1).getEntry(i) + "  ");
        BagInterface<String> leftOver2 = bag2.difference(bag1);  //difference should be c & f
        System.out.print("\nDifference 2:  ");
        for (int i = 0 ; i < leftOver2.getCurrentSize() ; i++)
            System.out.print(((ResizableArrayBag<String>) leftOver2).getEntry(i) + "  ");
    }
}