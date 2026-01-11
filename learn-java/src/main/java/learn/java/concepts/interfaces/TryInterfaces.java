package learn.java.concepts.interfaces;

public class TryInterfaces {

    static void main() {
        // ways of creating objects of implementations

        Person p1 = new Engineer();
        Person p2 = new Investor();
        Investor i = new Investor();
        Engineer e  = new Engineer();

        IO.println(i.profession());
    }

}
