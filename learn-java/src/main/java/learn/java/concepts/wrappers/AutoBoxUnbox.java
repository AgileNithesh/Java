package learn.java.concepts.wrappers;

public class AutoBoxUnbox {

    /**
     *  8 primitive data types have respective wrapper classes
     *  which brings the capability of reference data types
     *  means references can be processed efficiently in the
     *  program flow by modifying the original memory location
     *
     *  short,byte,int,float,double,long,char,boolean
     *  Short, Byte, Integer, Float, ..
     *
     *  primitive data types (int) are stored in stack memory
     *  Integer objects are stored in heap memory
     */

    public void performAutoBoxUnbox(){

        Integer a = 10; // Autoboxing
        int unbox = a; // AutoUnboxing

    }

}
