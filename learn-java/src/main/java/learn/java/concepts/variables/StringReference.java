package learn.java.concepts.variables;

public class StringReference {

    /**
     * Strings are immutable
     *
     * String is considered as reference data type.
     * In heap memory there is "String constant pool"
     *
     * Let's say a String variable a "hello" is present in pool
     * when a new variable b "hello" is created since the string is
     * present in pool variable b will hold the reference of variable a
     * it does not create new literal in constant pool
     *
     * String literal -- Strings present in String constant pool
     * String Object -- new String("as") new keyword leads to
     *                  new object creation in heap memory
     *
     */


    static void main() {
        // String literal
        String a = "hello";
        String b = "hello";

        IO.println(a.equals(b)); // true
        IO.println(a == b); // true

        // new keyword leads to new object creation in heap memory
        String c = new String("hello");

        IO.println(a.equals(c)); // true
        IO.println(a == c); // false

        /**
         *
         * In here i will hold the new reference for "new" string
         * "old" string literal in the pool will be eligible for
         * garbage collection. So the original string is not
         * altered rather a new literal is created in the pool.
         *
         */

        String i = "old";
        i = "new";
        IO.println(i); // new

    }

}
