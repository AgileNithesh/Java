package learn.java.concepts.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapInDepth {

    /**
     *
     * Map is an interface
     * - HashMap -- do not maintains the order
     * - HashTable -- synchronized version of HashMap -- ThreadSafe -- do not contain null key or value
     * - ConcurrentHashMap -- Thread safe version of HashMap similar to HashTable
     * - LinkedHashMap -- maintains the insertion order
     * - TreeMap -- sorts the data internally
     *
     * - size(), containsKey(obj o), containsValue(obj o), get(Object key), put(Obj k, obj, v)
     *
     *
     * Contract between equals() and hash()
     *  -- if o1 == o2 , then hash should be same for both object
     *  -- if k1 and k2 has the same hash value it mau not always the both objects are equal
     *
     *
     */

    static void main() {
        HashMapExample.hashmapEx();
    }


    /**
     * HashMap
     *
     * -- it is an array of Node<K,V> initial size of 16
     * -- each node will have -- hash, key, value, next
     *
     * Let's say put(1, "ab")
     *    compute hash for 1(Key) -- returns a hash number.
     *    hash % size -- mod 16 will result in a number corresponding to one of the bucket.
     *    Node -- hash, 1, ab, next == null
     *    If a new key 11 in map results in the hash same as key 1 it is called "Collision".
     *    then that bucket will create new node and link it to the existing node similar to LinkedList.
     *
     * Load Factor
     *    Default is 0.75 so 16 x 0.75 = 12
     *    when 13th element is inserted into the map it will trigger rehash and double the size
     *    this won't let the linked list to grow bigger
     *
     * Treefy Threshold
     *    Default threshold is 8
     *    as soon as one bucket hits 8 element this will trigger the Linked list to Balanced Search Tree
     *    Red-Black Tree to keep the max search complexity as log(n)
     *
     *
     * Average Time Complexity for Search, add, delete - O(1)
     * Worst scenario till threshold in LinkedList is O(n)
     * After threshold it is - O(log n)
     *
     *
     *
     *
     */

    private class HashMapExample{

        public static void hashmapEx(){

            Map<Integer, String> map = new HashMap<>();
            map.put(1,"ab");
            map.put(null, "hi");
            map.put(44, "hello");
            map.put(99, null);

            map.putIfAbsent(null, "bye"); // ignored
            map.putIfAbsent(99, "come"); // null value got replaced
            map.putIfAbsent(1, "hhhh"); // ignored

            for (Map.Entry<Integer, String> entry : map.entrySet()){

                IO.println(entry.getKey() + "-" + entry.getValue());

            }

            IO.println(map.size());

            IO.println(map.remove(null));

            IO.println(map.getOrDefault(1000, "default"));

            for (Map.Entry<Integer, String> entry : map.entrySet()){

                IO.println(entry.getKey() + "-" + entry.getValue());

            }

            for(Integer i:map.keySet()){
                IO.println(i);
            }

            for(String s: map.values()){
                IO.println(s);
            }

        }

    }

}
