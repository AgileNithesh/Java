package learn.java.concepts.functionalinterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TypesOfFuncInterface {

    static void main() {

        //Consumer accepts a single parameter and returns no result
        Consumer<Integer> login = (Integer pin) -> IO.println("Hello this is billionaire Nithesh from London");
        login.accept(10);

        //Supplier accepts no input but produce a result
        Supplier<String> investor = () -> "Business tycoon Nithesh";
        IO.println(investor.get());

        //Function<T, R> T is input and R is output
        Function<Integer, String> demofunc = (i) -> {if(i==10) return "ten"; return "";
        };
        IO.println(demofunc.apply(10));


        //Predicate -- accept but always return boolean
        Predicate<Integer> isEven = (i) -> i%2 == 0 ? true : false ;
        IO.println(isEven.test(10));

    }


}
