package learn.java.concepts.methods;

public class Methods {

    /**
     *  System defined methods -- Methods already available in ex: Math.sqrt(2)
     */

    /**
     * overloading methods -- same name but different argument
     *
     *  int getTotal( int price );
     *  double getTotal( int price, int discount );
     *
     *  In below methods return types are different which is valid but
     *  method overloading is not valid on return type alone which is invalid
     *  always there should be difference in method arguments.
     */

    int getTotal(int price){
        return price;
    }

    double getTotal(int price, int discount){
        return price - discount;
    }

    /**
     *
     * Overridden method - when child class contains the same method as parent.
     *
     */

    private static class Trader {
        public void who (){
            IO.println("who");
        }

        public void parentMethod(){
            IO.println("Parent");
        }
    }

    private static class  Nithesh extends Trader {
        @Override
        public void who(){
            IO.println("Nithesh");
        }

        public void childMethod(){
            IO.println("child");
        }
    }


    static void main() {
        Trader t = new Trader();
        t.who();

        Trader n = new Nithesh();
        n.who();

        Nithesh nn = new Nithesh();
        nn.who();
        nn.parentMethod();
        nn.childMethod();
    }

    /**
     * Static Methods - Can be called with just the class name no need of
     * creating an instance. Static method cannot access non-static methods
     * or variables.
     *
     * Static methods cannot be overridden
     *
     * Usage -- Utility methods, factory design pattern
     */

    public class Vehicle {

        public static int id;

        public static void generateID(){
            id++;

            // static method need an object to access non-static method
            Methods obj = new Methods();
            obj.getTotal(id);

        }

        public void which(){

            // non static method can access static method directly
            generateID();
            IO.println("vehicle");
        }
    }


    /**
     *
     * final method - cannot be overridden
     *
     *
     */

    public final void finalMethod(){

    }

    /**
     * abstract method - can only be defined in an abstract class
     * implementation is done in child class
     */

    private abstract class AbClass{

        public abstract void childImeplementation();

        public void helloAbstract(){
            IO.println("hello abstract");
        }

    }

    private class childClass extends AbClass{

        @Override
        public void childImeplementation() {
            IO.println("I'm child");
        }
    }

    /**
     * variable arguments - only one variable argument should be present
     * always variable arguments should be in the last method signature
     */

    public int calculateSum(int... a){

        int c = 0;
        for (int i : a){
            c = c + i;
        }
        return c;
    }

    // below is valid
    public void variableArg(String s, int... i){

    }

    // below is invalid
    // public void variableArgInvalid(int... i, String s){
    // }
}
