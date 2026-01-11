package learn.java.concepts.constants;

public class TryConstants {

    public static void main() {
        ConstantVariables v1 = new ConstantVariables();
        ConstantVariables v2 = new ConstantVariables();

        /**
         * modifying non final variable static variable holds a single reference across
         * all instances if it in not final it gets altered.
         */

        IO.println(v1.id); // 10
        v1.id = 200;
        IO.println(v2.id); // 200

        /**
         * final values cannot be modified it's a compilation error
         */
        IO.println(v1.FINAL_ID);

        //v1.FINAL_ID = 2;

    }

}
