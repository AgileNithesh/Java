package learn.java.concepts.collections;

import javax.lang.model.type.ArrayType;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorExample {

    /**
     * Comparator and Comparable both provides a way to sort the collection of objects
     *
     * Internal sorting algo uses comparator to compare objects to decide if a swap is required or not
     *  > 0 -- do swap
     *  < 0 -- do not swap
     *
     *
     *  Comparator has method with two objects -- int compare(T o1, To2)
     *  Comparable has only one object in the method -- int compareTo(T o2)
     *  - since this has one obj alone it doesn't support the lambda way
     *  - has to be implemented in the custom object class itself
     *
     */


    private static class Cars{
        String type;
        String fuel;

        Cars(String type, String fuel){
            this.fuel = fuel;
            this.type = type;
        }

        @Override
        public String toString() {
            return type + "-" + fuel;
        }
    }


    static void main() {
        Integer[] a = {1,5,2,4,7};

        // comparator returns >0 if val2 is more then it will swap
        Arrays.sort(a, (val1, val2) -> val1 - val2 );
        IO.println(Arrays.toString(a));

        // comparator returns <0 if val2 is more then it will swap
        // leads to descending order
        Arrays.sort(a, (val1, val2) -> val2 - val1 );
        IO.println(Arrays.toString(a));

        Cars[] carArray = new Cars[3];
        carArray[0] = new Cars("SUV", "Petrol");
        carArray[1] = new Cars("Sedan", "Diesel");
        carArray[2] = new Cars("HatchBack", "EV");

        Arrays.sort(carArray, (Cars obj1, Cars obj2) -> obj2.type.compareTo(obj1.type));

        IO.println(Arrays.toString(carArray));

        EmployeeCompare[] emp = new EmployeeCompare[3];
        emp[0] = new EmployeeCompare("Kohli", "entertainment");
        emp[1] = new EmployeeCompare("Nithesh", "CEO");
        emp[2] = new EmployeeCompare("lion", "cleaner");

        Collections.sort(Arrays.asList(emp));
        IO.println(Arrays.toString(emp));



    }

    // comparator can be implemented in the object class as well to sort instead of passing it in lambda expression
    private static class CarCompare implements Comparator<CarCompare> {
        String type;
        String fuel;

        CarCompare(String type, String fuel){
            this.fuel = fuel;
            this.type = type;
        }

        @Override
        public String toString() {
            return type + "-" + fuel;
        }

        @Override
        public int compare(CarCompare o1, CarCompare o2) {
            return o1.type.compareTo(o2.type);
        }
    }



    // Comparable

    private static class EmployeeCompare implements Comparable<EmployeeCompare> {
        String name;
        String unit;

        EmployeeCompare(String name, String unit){
            this.name = name;
            this.unit = unit;
        }

        @Override
        public String toString() {
            return name + "-" + unit;
        }

        @Override
        public int compareTo(EmployeeCompare o2) {
            return this.name.compareTo(o2.name);
        }
    }


}
