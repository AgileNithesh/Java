package learn.java.concepts.sealedclasses;

public class SealedClasses {

    /**
     * Sealed classes
     *
     * - To gain control over inheritance -- which classes can extend a class
     * - Permitted class should have direct inheritance of parent
     * - child should be final or sealed or non-sealed
     */

    static void main() {
        Person p = new Person("a", "b");
        IO.println(p.name());
    }

    public record Person( String name, String address){}



    private static final class Circle extends Sharpe {

    }

    private static non-sealed class Square extends Sharpe {

    }

    private static sealed class Sharpe permits Circle , Square {

    }

    private static class Colour {


    }

}
