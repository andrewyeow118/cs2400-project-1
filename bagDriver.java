public class bagDriver
{
    public static void main(String[] args)
    {
        BagInterface<String> bag1 = new ResizableArrayBag<>();
        BagInterface<String> bag2 = new ResizableArrayBag<>();
        bag1.add("a");
        bag1.add("a");
        bag1.add("a");
        bag1.add("b");
        bag1.add("b");
        bag1.add("b");
        bag1.add("c");
        bag1.add("c");
        bag1.add("d");
        bag1.add("d");
        bag2.add("a");
        bag2.add("b");
        bag2.add("b");
        bag2.add("b");
        bag2.add("c");
        bag2.add("d");
        BagInterface<String> everything = bag1.union(bag2);
        System.out.print("Union:  ");
        for (int i = 0 ; i < everything.getCurrentSize() ; i++)
        {
            System.out.print(everything.getEntry(i) + "  ");
        }
        System.out.println("\n");

        BagInterface<String> commonItems = bag1.intersection(bag2);
        System.out.print("Intersection:  ");
        for (int i = 0 ; i < commonItems.getCurrentSize() ; i++)
        {
            System.out.print(commonItems.getEntry(i) + "  ");
        }
        System.out.println("\n");

        testDifference();
    }

    public static void testDifference()
        {
            BagInterface<String> bag1 = new ResizableArrayBag<>();
            BagInterface<String> bag2 = new ResizableArrayBag<>();
            String[] bag1arr = {"a", "a", "b", "c", "c", "d", "e", "e", "z", "g"};
            String[] bag2arr = {"a", "b", "c", "c", "c", "d", "e", "f"};
            for (int i = 0 ; i < bag1arr.length ; i++)
                bag1.add(bag1arr[i]);
            for (int i = 0 ; i < bag2arr.length ; i++)
                bag2.add(bag2arr[i]);
            BagInterface leftOver = bag1.difference(bag2);  //difference should be {a, e, z, g}
            System.out.print("Difference:  ");
            for (int i = 0 ; i < leftOver.getCurrentSize() ; i++)
            {
                System.out.print(leftOver.getEntry(i) + "  ");
            }
        }
}
