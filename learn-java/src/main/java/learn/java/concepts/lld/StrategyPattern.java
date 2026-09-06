package learn.java.concepts.lld;


/**
 * Strategy Design Pattern is a behavioral design pattern that allows you to
 * define a family of algorithms or behaviors, put each of them in a separate class,
 * and make them interchangeable at runtime. This pattern is useful when you want to
 * dynamically change the behavior of a class without modifying its code.
 *
 */
public class StrategyPattern {


    private class Vehicle{

        DriveStrategy driveStrategy;

        public Vehicle(DriveStrategy driveStrategy){
            this.driveStrategy = driveStrategy;
        }

        public void drive(){
            IO.println(" this class "+ this.getClass().getSimpleName());
            driveStrategy.drive();
        }
    }

    public class GoodsVehicle extends Vehicle {

        public GoodsVehicle(DriveStrategy driveStrategy) {
            super(driveStrategy);
        }
    }


    public   class OffroadVehicle extends Vehicle{

        public OffroadVehicle(DriveStrategy driveStrategy) {
            super(driveStrategy);
        }
    }


    // strategy
    private interface DriveStrategy{
        public void drive();
    }


    private static class NormalDrive implements DriveStrategy{
        @Override
        public void drive() {
         IO.println("Normal Drive");
        }
    }

    private class SportsDrive implements DriveStrategy{

        @Override
        public void drive() {
            IO.println("Sports Drive");
        }
    }
}

