package learn.java.concepts.collections;

import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapInDepth {

    /**
     *
     * TreeMap
     *
     * - Sorted by natural order or by the supplied comparator
     * - Based on Red-Black tree( Self balancing BST)
     * - O(log n) for insert, remove, get
     *
     *
     */

    static void main() {

        Map<Integer, String> treeMap = new TreeMap<>((k1, k2) -> k2 -k1);

        treeMap.put(43,"fsgd");
        treeMap.put(22, "qwe");
        treeMap.put(99, "mis");

        // descending order
        treeMap.forEach((k,v) -> IO.println(k + " - " + v));

        // stores keys in natural order
        SortedMap<Integer, String> sortedMap = new TreeMap<>();

        sortedMap.put(12, "ewgf");
        sortedMap.put(3, "asfd");
        sortedMap.put(11, "dasf");
        sortedMap.put(123, "fsd");

        IO.println(sortedMap.headMap(12));
        IO.println(sortedMap.tailMap(12));

        // NavigableMap

        NavigableMap<Integer, String> navMap = new TreeMap<>();
        navMap.put(11, "adsa");
        navMap.put(43, "rgsfd");

        IO.println(navMap.descendingMap());

    }


}
