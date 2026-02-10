package learn.java.concepts.multithreading;

public class MultiThreading {

    /**
     * 2 ways to create parallel process
     *
     * 1. Implementing Runnable Interface
     *    It is a functional interface which has a method run
     *
     * 2. Extending Thread class
     *
     *
     */

    static void main() {

        Runn r = new Runn();
        r.run();
        IO.println("a");

        RunClass ee = new RunClass();
        ee.run();
    }

    private static class Runn implements Runnable{

        @Override
        public void run() {
            IO.println("run");
        }
    }

    private static class RunClass extends Thread{
        @Override
        public void run() {
            super.run();
            IO.println("Thread");
        }
    }

}
