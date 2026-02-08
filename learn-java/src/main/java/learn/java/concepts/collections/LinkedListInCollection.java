package learn.java.concepts.collections;

import java.util.LinkedList;
import java.util.Vector;

public class LinkedListInCollection {

    /**
     * LinkedList
     * - It is a doubly linked list
     * - Data Structure and Collection  name is same
     * - Implements both List and DeQue interface
     *
     * - maintains insertion order
     *
     *
     * - Faster than ArrayList since no need of shifting
     * - insertion in end or start -- O(1)
     * - insertion at particular index -- O(n)
     * - search -- O(n)
     *
     *
     * - Thread safe -- Vector
     */

    static void main() {

        LinkedList<Integer> list = new LinkedList<>();

        // using LinkedList as Deque

        list.addFirst(1);
        list.addLast(3);
        list.addLast(454);

        IO.println(list);

        list.removeFirst();
        list.removeLast();

        IO.println(list);

        // using as list

        list.add(323);
        IO.println(list);
        IO.println(list.get(1));


        Vector<Integer> vector = new Vector<>();
        vector.addFirst(1);
        vector.add(1);
    }

    private class Node{

        String data;
        Node next;
        Node previous;
    }

}
