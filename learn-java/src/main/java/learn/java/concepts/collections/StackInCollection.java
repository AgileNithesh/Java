package learn.java.concepts.collections;

import java.util.Stack;

public class StackInCollection {

    /**
     *
     * Stack
     *
     * - LIFO operation
     * - Stack extends Vector hence it is thread safe
     *
     * - insertion, deletion - O(1)
     * - search - O(n)
     * - retrieval order won't match insertion order
     */

    static void main() {

        Stack<Integer> stack = new Stack<>();

        stack.push(2);
        stack.push(67);
        stack.push(67);

        stack.push(7436);

        IO.println(stack);

        IO.println(stack.pop());

        IO.println(stack);
    }

}
