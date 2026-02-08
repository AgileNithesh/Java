package learn.java.concepts.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListInCollection {

    /**
     *
     * List is an ordered collection of objects
     *
     * - In Queue insertion/removal/access can only happen either at the start or end
     * - In List data can be modified from anywhere using index
     *
     *
     * - all collection methods and some new methods in list interface
     *
     * - add(int index, E ele) -- if an element exists in position then it shifts old ele to it's right
     * - addAll(int index, Collection c) -- moves all subsequent ele's to right if any
     * - replaceAll(UrinaryOperator op) -- replaces each ele after applyinng the operator
     * - set(int index, E ele) -- replace an existing ele at the position
     * - remove(int index) -- shifts subsequent element to the left
     * - indexOf(Obj o) -- returns first occurrence
     * - lastIndexOf(Obj o) -- returns the last occurrence
     * - ListIterator<E> listIterator() -- exposes some methods to iterate in the backward direction as well etc..
     * - List<E> subList(int fromIndex, int toIndex) -- any change in the sublist will change in mail list and vice versa
     *
     *
     */


    /**
     * ArrayList
     *
     * - insertion
     *   - O(1) -- insert in end
     *   - O(n) -- insert in particular index, bcz right shift
     *   - O(n) -- if increase in capacity after threshold hits
     *
     * - removal -- O(1) -- bcz of left shift of remaining elements
     *
     * - search ---O(1) -- to get a particular index, O(n) for traverse
     *
     * -- null, duplicates allowed
     *
     * -- Thread Safe is -- CopyOnWriteArrayList
     *
     */

    static void main() {

        List<Integer> list1 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(4);

        List<Integer> list2 = new ArrayList<>();

        list2.add(100);
        list2.add(300);
        list2.add(500);

        list1.addAll(2, list2);

        list1.forEach(val -> IO.println(val));

        IO.println("--------Urinary operator----------");
        // Urinary operator
        list1.replaceAll(val -> val * 2);
        list1.forEach(val -> IO.println(val));

        IO.println("-------------");
        IO.println(list1.get(2));

        IO.println("-------------");
        list1.set(2, 0000);
        IO.println(list1);

        list1.remove(2);
        IO.println(list1);

        IO.println(list1.indexOf(600));


        ListIterator<Integer> listIterator = list1.listIterator();

        while(listIterator.hasNext()){

            int val = listIterator.next();
            IO.print(val + " - " + "," + "previous index" + " = " + listIterator.previousIndex() + "|");
            if(val == 600) {
                listIterator.add(-999);
                IO.println("--->"+list1+"<---");
            }

        }

        CopyOnWriteArrayList threadSafe = new CopyOnWriteArrayList();
        threadSafe.add(1);


    }
}
