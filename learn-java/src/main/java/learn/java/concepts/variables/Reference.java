package learn.java.concepts.variables;

public class Reference {

    static void main() {

        /**
         * when a new keyword is used a memory block is allocated in
         * "heap memory".
         * "nit_object" object name is the reference to the memory block created
         * in the memory.
         *
         *
         */

        //class_name object name = the class
        Nithesh nit_object = new Nithesh();

        nit_object.weight = 60;
        increase_weight(nit_object);

        /**
         *  it is 65 since the reference is passed original value is updated
         */
        IO.println(nit_object.getWeight());

        Nithesh nit_object2 = nit_object;

        increase_weight(nit_object);

        /**
         *  70 since the nit_object2 was the same reference as nit_object
         *  means it is pointing to the same memory block as nit_object so
         *  the value updated using nit_object is reflected in nit_object2 as well
         */
        IO.println("ojb2 --> " + nit_object2.getWeight());

    }

    private static void increase_weight(Nithesh nit) {

        nit.weight = nit.weight + 5;

    }


    /**
     *  4 types of reference data type
     *
     *  class
     *  string
     *  interface
     *  array
     *
     */

    private static class Nithesh {

        int weight; // property

        // function
        public int getWeight(){
            return weight;
        }

        public void setWeight(int w){
            this.weight = w;
        }
    }

}



