package learn.java.concepts.constructors;

public class Constructor {


    /**
     *
     *  Constructor is used to create an instance
     *  Constructor cannot be - static, final, abstract or synchronized
     *  In inheritance child constructor always invokes parent class first -- hidden super();
     *
     *  Constructor cannot be final - bcz anyway constructor cannot be overridden
     *  not abstract - constructor cannot be inherited to implement in child class
     *  not static - it will block the chaining implementation
     *
     *  Interface won't have constructor - since creating an instance will be of no use
     *                                      bcz the implementation of methods will be available
     *                                      only in the implemented class
     *
     *
     *  Types of constructor -- if any constructor is declared then default constructor is negated
     *
     *  Default -- Constructor(){} -- if no constructor is declared explicitly then java will provide default constructor
     *  No arg Constructor -- explicitly declaring might have some statements inside -- Constructor(){ // statement}
     *  Parameterized -- Constructor(String instancev){this.instancev = instancev}
     *                   there can be multiple parameterized constructor which is called Constructor Overloading.
     *
     *  private constructor -- private Constructor(){} -- to disable object creation or instance creation outside the class
     *
     *
     */

    // Constructor chining

    public class Calculate{

        String name;
        int id;

        Calculate(){
            this(10);
        }

        Calculate(int id){
            this(id, "name");
        }

        Calculate(int id, String name){
            this.name = name;
            this.id = id;
        }
    }

    // Singleton pattern
    static class PrivateCon {

        private PrivateCon(){

        }

        public PrivateCon getPrivateConInstance(){
            return new PrivateCon();
        }

    }

    // The constructor -- don't have any return type bcz implicitly it is return type is the instance of same class
    Constructor(){

    }

    // method can also have the same name, at runtime java differentiate constructor vs method
    public int Constructor(){

        return 0;
    }

}
