package learn.java.concepts.functionalinterface;


public class Parrot implements Bird{


    @Override
    public void canFly(String val) {
        IO.println("Fly");
    }
}