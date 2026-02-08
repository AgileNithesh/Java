package learn.java.concepts.collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SetInCollections {

    /**
     * Set
     *
     * - Doesn't allow duplicate value, null is valid value
     * - Insertion order not maintained
     * - Set can not be accessed via index
     *
     *
     * Thread Safe
     * - ConcurrentHashMap
     *
     */

    static void main() {

        /**
         *
         * HashSet
         *
         * - Data Structure internally used is HashMap
         * - It is not thread safe
         *
         *
         */

        Set<Integer> set = new HashSet<>();

        set.add(12);
        set.add(13); // true or false

        Set<Integer> set1 = new HashSet<>();

        set1.add(12);
        set1.add(14); // true or false

        IO.println(set1);
        set.retainAll(set1); // performs intersection

        IO.println(set);
        set.addAll(set1); // performs union

        IO.println(set);

        Iterator<Integer> setIterator = set.iterator();

        try {
            while(setIterator.hasNext()){

                int val = setIterator.next();
                if(val == 12){
                    set.add(34); // throws concurrent modification exception since a thread is accessing for read
                    // since it is not synchronized internally
                }

            }
        } catch ( Exception e){
            IO.println(e);
        }


        // Thread Safe

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>();
        Set<Integer> safeSet = concurrentHashMap.newKeySet();
        safeSet.add(123);

        Iterator<Integer> iterator = safeSet.iterator();

        while(iterator.hasNext()){

            if(iterator.next() == 123){
                safeSet.add(22); // success since the set is synchronized
            }

        }

        IO.println(safeSet);


        /**
         *
         * LinkedHashSet
         *
         * - Internally uses LinkedHashMap
         * - Not thread safe
         * - maintains insertion order
         *
         *
         */

        Set<Integer> linkedSet = new LinkedHashSet<>();

        linkedSet.add(12);
        linkedSet.add(43);
        linkedSet.add(1);

        IO.println(linkedSet);

        // Thread Safe

        Set<Integer> safeLinkedSet = Collections.synchronizedSet( new LinkedHashSet<>());


        /**
         *
         * TreeSet
         *
         * - internally uses ThreeMap
         * - can not store null value
         *
         *
         */

        Set<Integer> treeSet = new TreeSet<>();

        treeSet.add(12);
        treeSet.add(43);
        treeSet.add(1);

        // ascending order
        IO.println(treeSet);

        // passing comparator for descending order
        Set<Integer> treeSetDesc = new TreeSet<>((a, b) -> b - a);

        treeSetDesc.add(12);
        treeSetDesc.add(43);
        treeSetDesc.add(1);

        // descending order
        IO.println(treeSetDesc);

    }

}
