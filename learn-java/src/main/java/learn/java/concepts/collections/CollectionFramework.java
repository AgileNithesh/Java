package learn.java.concepts.collections;

import java.util.*;

public class CollectionFramework {

    /**
     *
     *  Collections is group of objects and framework is the generic architecture for different types of
     *  Objects. Generic method for add, update, delete, search etc..
     *
     *  Iterable ->  collection extends itrerable
     *
     *  Iterable helps in traversing
     *
     *
     *
     *  Collection vs Collections
     *  -- Collections is the utility class provides methods like sort(), min(), swap(), copy(), etc..
     *  -- Collection is an interface which exposes methods which is implemented by classes like ArrayList, Queue, etc.
     *
     */

    static void main() {

        checkIterationMethods();
        collectionCheck();
        collectionsCheck();

    }

    static void collectionsCheck(){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(27);
        list.add(22);

        Collections.sort(list);
        Collections.frequency(list, 2);
    }

    static void collectionCheck(){

        // Collection interface provides methods to work on group of objects
        // ex: size(), isEmpty(), toArray(), contains(), iterator(), add(),
        // clear(), equals(), stream(), parallelStream().. etc

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(27);
        list.add(22);

        list.size();

        list.isEmpty();

        list.contains(1);

        list.remove(2); // remove value in index
        list.remove(new Integer(22)); // remove value

        Stack<Integer> stack = new Stack<>();

        stack.addAll(list); // add one type of collection into another

        stack.containsAll(list);
        stack.removeAll(list);

        stack.clear();
        stack.isEmpty();
    }




    static void checkIterationMethods(){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(27);
        list.add(22);


        Iterator<Integer> iterator = list.iterator();

        while(iterator.hasNext()){ // check if values exist

            int val = iterator.next(); // return current value
            IO.println(val);

            if(val == 27){
                iterator.remove(); // remove current value
            }
        }

        // any collection can be iterated through enhanced for or foreach loop
        IO.println("after removing");
        for(int a: list){
            IO.println(a);
        }

        // foreach method, :: method interface
        list.forEach(IO::println);
    }

}
