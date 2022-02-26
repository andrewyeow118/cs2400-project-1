public class LinkedBagTest {
    BagInterface<Integer> bag1 = new LinkedBag<>();
    BagInterface<Integer> bag2 = new LinkedBag<>();
    
    //case 1 normal
    bag1.add(3);
    bag1.add(5);
    bag2.add(3);
    //union is 3, 5, 3
    bag1.union(bag2);
    //intersection is 3
    bag1.intersection(bag2);
    //diference is 5
    bag1.difference(bag2);

    bag1.clear();
    bag2.clear();

    //case 2 duplicates 
    bag1.add(1);
    bag1.add(3);
    bag1.add(5);
    bag1.add(3);
    bag2.add(3); 
    bag2.add(1);
    //union is 1, 3, 5, 3, 3, 1
    bag1.union(bag2);
    //intersection is 1, 3
    bag1.intersection(bag2);
    //diference is 5, 3
    bag1.difference(bag2);

    bag1.clear();
    bag2.clear();

    //case 3 empty bags
    bag2.add(3); 
    bag2.add(1);
    //union is 3, 1
    bag1.union(bag2);
    //intersection is null
    bag1.intersection(bag2);
    //diference is null
    bag1.difference(bag2);

    bag1.clear();
    bag2.clear();

    //case 4 null values 
    bag1.add(null);
    bag2.add(3); 
    bag2.add(1);
    //union throw exception
    bag1.union(bag2);
    //intersection throw exception
    bag1.intersection(bag2);
    //diference throw exception
    bag1.difference(bag2);

}
