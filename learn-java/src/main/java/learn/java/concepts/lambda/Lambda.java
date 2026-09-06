package learn.java.concepts.lambda;

import learn.java.concepts.functionalinterface.Bird;

// lambda reduces the verbose in functional interface implementation
// lambda expression is a way to implement functional interface
public class Lambda /*implements Bird*/ {


//    @Override
//    public void canFly(String val) {
//     IO.println("checking wait impl "+val);
//    }


    Bird checkLambda (){

       Bird e = (s) -> IO.println("checking lambda wait "+ s);
       return e;
    }


    static void main() {
        Lambda a = new Lambda();
//        a.canFly("owl");
        a.checkLambda().canFly("owl");
    }

}
