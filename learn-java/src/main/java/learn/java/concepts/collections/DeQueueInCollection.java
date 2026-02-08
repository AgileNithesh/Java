package learn.java.concepts.collections;

import java.util.ArrayDeque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class DeQueueInCollection {

    /**
     *
     * Dequeue -- Double ended queue is addition and removal can be done at both ends
     * - we can use DeQueue to implement STACK (LIFO) and QUEUE (FIFO) both.
     * - available methods are collections + queue + Deque methods
     *
     * - addFirst() -- Exception if fail
     * - offerFirst() -- false if fail
     * - addLast()
     * - offerLast()
     * - similarly removeFirst(), pollFirst(), removeFirst(), removeLast()
     * - getFirst() -- Exception if fail
     * - peekFirst() -- false if fail
     * - getLast()
     * - peekLast()
     *
     * - add(), remove() etc.. calls respective Last() methods like a typical queue
     * - push() calls addFirst()
     * - pop() calls removeFirst()
     *
     *
     * Insertion is mostly O(1) unless the internal resize to twice the capacity as it grows -> O(n)
     * Deletion - O(1)
     * Get elements at first or Last - O(1)
     *
     */


    /**
     * ArrayDeque
     * - Maintains insertion order
     * - Not thread Safe
     * - Thread Safe is ConcurrentLinkedDequeue
     */

    static void main() {

        ArrayDeque<Integer> ardq = new ArrayDeque<>();

        ardq.addLast(1);
        ardq.addLast(2);
        ardq.addLast(5);

        IO.println(ardq.removeLast());

        ArrayDeque<Integer> arrayDequeAsStack = new ArrayDeque<>();

        arrayDequeAsStack.addFirst(1);
        arrayDequeAsStack.addFirst(3);
        arrayDequeAsStack.addFirst(5);

        IO.println(arrayDequeAsStack.removeFirst());


        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();

    }

}
