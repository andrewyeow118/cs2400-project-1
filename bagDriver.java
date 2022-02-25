public class bagDriver
{
    public static void main(String[] args)
    {
        BagInterface<String> bag1 = new ResizableArrayBag<>();
        BagInterface<String> bag2 = new ResizableArrayBag<>();
        bag1.add("a");
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        bag1.add("c");
        bag1.add("d");
        bag2.add("a");
        bag2.add("b");
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        /*BagInterface<String> everything = bag1.union(bag2);
        for (int i = 0 ; i < everything.getCurrentSize() ; i++)
        {
            System.out.print(everything.getEntry(i) + "  ");
        }*/

        /*BagInterface<String> commonItems = bag1.intersection(bag2);
        for (int i = 0 ; i < commonItems.getCurrentSize() ; i++)
        {
            System.out.print(commonItems.getEntry(i) + "  ");
        }*/ 

        BagInterface<String> leftOver = bag1.difference(bag2);
        for (int i = 0 ; i < leftOver.getCurrentSize() ; i++)
        {
            System.out.print(leftOver.getEntry(i) + "  ");
        }
    }
}
