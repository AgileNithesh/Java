package learn.java.concepts.multithreading;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTry {

    /**
     *
     * ThreadLocal class provides access to Thread-Local variables.
     * Thread-Local variable hold value for particular thread.
     * Each thread has its own copy of thread local variable
     *
     */


    static void main() throws InterruptedException {

        ThreadLocal<String> threadObj = new ThreadLocal<>();

        threadObj.set(Thread.currentThread().getName());

        Thread thread1 = new Thread(() -> {
           threadObj.set(Thread.currentThread().getName());
           IO.println("thread1");
        });

        thread1.start();
        Thread.sleep(2000);

        IO.println(threadObj.get());

        // if the thread to be reused, local variable need to be reset or cleared

        ThreadLocal<String> tlo = new ThreadLocal<>();

        ExecutorService pool = Executors.newFixedThreadPool(5);

        pool.submit( () -> {
            tlo.set(Thread.currentThread().getName());
            // remove current thread value after done
            tlo.remove();
        });

        for(int i=0; i<10; i++){
            pool.submit( () -> {
               IO.println(tlo.get());
            });
        }

        // without shoutdown the thread stays active
        pool.shutdown();
        /**
         * below is the output for above without using tlo.remove() method
         *
         * null
         * null
         * null
         * null
         * null
         * pool-1-thread-1
         * null
         * null
         * pool-1-thread-1
         * null
         *
         */

    }

}
