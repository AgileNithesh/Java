package learn.java.concepts.functionalinterface;

//functional interface is the interface with only one abstract method
//can have default and static methods also the methods in Object class
@FunctionalInterface
public interface Bird{
    void canFly(String val);

    default void arielView(){
        //default implementation
        IO.println("I can see from top");
    }

    static void canEat(){
        //static method
    }
}