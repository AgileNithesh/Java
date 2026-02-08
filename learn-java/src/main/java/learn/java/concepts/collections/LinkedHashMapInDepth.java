package learn.java.concepts.collections;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapInDepth {

    /**
     *
     * LinkedHashMap
     * - Maintains insertion order or access order
     *      - access order -- high frequent used items are at the last and less frequent in the end
     * - similar to HashMap but uses Double-LinkedList each bucket last element will contain next
     *   bucket first element address as next element
     *
     * Time Complexity is similar to HashMap
     *
     * - Not Thread Safe
     * - Have to explicitly make it synchronized
     *
     */


    static void main() {

        Map<Integer, String> linkedMap = new LinkedHashMap<>();

        linkedMap.put(44, "dafs");
        linkedMap.put(99, "ssdf");
        linkedMap.put(31, "qey");


        // maintains the insertion order through Double-LinkedList
        linkedMap.forEach( (key, val) -> IO.println(key + " - " + val));


        // custom access order -- one application can be caching

        Map<Integer, String> linkedMapAccessOrder = new LinkedHashMap<>(16, 0.75f, true);

        linkedMapAccessOrder.put(44, "dafs");
        linkedMapAccessOrder.put(99, "ssdf");
        linkedMapAccessOrder.put(31, "qey");

        // access one ele
        linkedMapAccessOrder.get(99);

        // moves 99 to the last
        linkedMapAccessOrder.forEach( (key, val) -> IO.println(key + " - " + val));


        // Thread Safe
        Map<Integer, String> safeMap = Collections.synchronizedMap(new LinkedHashMap<>());
        safeMap.put(34, "I'm safe");

    }

}
