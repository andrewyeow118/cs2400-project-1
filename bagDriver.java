public class bagDriver
{
    public static void main(String[] args)
    {
        BagInterface<String> bag1 = new ResizableArrayBag<>();
        BagInterface<String> bag2 = new ResizableArrayBag<>();
        bag1.add("a");
        bag1.add("a");
        bag1.add("a");
        System.out.println(bag1.toArray());
    }
}
