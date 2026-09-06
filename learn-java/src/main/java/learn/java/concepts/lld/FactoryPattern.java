package learn.java.concepts.lld;

public class FactoryPattern {

    /**
     * Factory Pattern
     *
     * - Creation design pattern.
     * - Used when we want to encapsulate object creation and
     *   related creation logic at one place
     * - In future if there any change in creation logic
     */

    private enum Shapes{

        CIRCLE,
        SQUARE

    }

    private class ShapeFactory{
        // static method to create and return the Shape objects
        public static Shape createShape(Shapes s){

          if(Shapes.CIRCLE == s){
              return new Circle();
          } else if (Shapes.SQUARE == s){
              return new Square();
          } else {
              return null;
          }

        }
    }



    private interface Shape{
        void draw();
        void compute();
    }


    private static class Circle implements Shape{

        @Override
        public void draw() {

        }

        @Override
        public void compute() {

        }
    }

    private static class Square implements Shape{

        @Override
        public void draw() {

        }

        @Override
        public void compute() {

        }
    }

}
