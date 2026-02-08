package learn.java.concepts.collections;

import java.util.PriorityQueue;

public class QueueInCollections {

    static void main() {
        PriQue.minprique();
        PriQue.maxprique();
    }

    // Queue is an interface and child of Collection interface
    // Generally it is FIFO but there are exception like PriorityQueue
    // Supports all the methods available in collection and some other

    // add() -- Exception if insertion fails -- log(n)
    // offer() -- false if insertion fails
    // poll() -- removes and returns the head, Exception if empty  -- log(n)
    // remove() -- same as poll but returns Exception if empty
    // peek() -- retrieves head element but doesn't remove, null if emplty - O(1)
    // element() -- same as peek but exception if empty

    /**
     *
     * 2 types of Priority Queue -- min , max
     * - It is absed on priority heap
     * - Elements are ordered according to either Natural Ordering or by Comparator
     * - doesn't maintain insertion order
     * - Not thread safe
     * - Thread Safe -- PriorityBlockingQueue
     *
     */


    private class PriQue{

        public static void minprique(){
            PriorityQueue<Integer> minpq = new PriorityQueue<>();

            minpq.add(1);
            minpq.add(10);
            minpq.add(2);
            minpq.add(4);

            // streams in level order traversal after constructing min heap
            // 1, 4, 2, 10
            minpq.forEach(val -> IO.println(val));

            while  (!minpq.isEmpty()){

                IO.println("removed the top "+ minpq.poll());

            }

        }

        public static void maxprique(){

            // passed comparator to change the ordering
            PriorityQueue<Integer> maxpq = new PriorityQueue<>((Integer a, Integer b) -> b -a);

            maxpq.add(1);
            maxpq.add(10);
            maxpq.add(2);
            maxpq.add(4);

            // streams in level order traversal after constructing max heap
            // 10, 4, 2, 1
            maxpq.forEach(val -> IO.println(val));

            while  (!maxpq.isEmpty()){

                IO.println("removed the top "+ maxpq.poll());

            }

        }


    }


}
