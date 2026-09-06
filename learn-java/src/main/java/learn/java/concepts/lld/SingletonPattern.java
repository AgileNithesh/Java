package learn.java.concepts.lld;


/**
 * The Singleton pattern ensures that a class has only one instance
 * and provides a global point of access to that instance.
 *
 * This is useful for scenarios where you want to restrict object creation
 * to a single instance, such as a configuration manager or a database
 * connection pool.
 */

public class SingletonPattern {



    private static SingletonPattern sp;

    // private constructor to disable initialization outside this class
    private SingletonPattern(){

    }

    public static SingletonPattern getInstance() {

        if (sp == null){
            sp = new SingletonPattern();
        }
        return sp;
    }



}
