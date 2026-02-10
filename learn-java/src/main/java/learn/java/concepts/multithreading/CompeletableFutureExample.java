package learn.java.concepts.multithreading;

import java.util.Comparator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CompeletableFutureExample {


    /**
     * CompletableFuture
     *
     *  - Advanced version of Future
     *  - Provides additional capability like chaining
     *
     *  - supplyAsync() -- initiates an Async operation
     *    supplier is executed Asynchronously in a seperate thread
     *    By default it uses fork join pool executor.
     *
     *  - orTimeOut(2, Time.SECONDS) -- is important or else the thread will
     *                                  wait indefinitely
     *
     */

    static void main() throws ExecutionException, InterruptedException {


        IO.println(supplyMethod().get());

        //thenApplyExample();
        //thenApplyAsyncExample();
        //composeMethods();
        acceptMethods();
        combineMethods();

    }

    /**
     * Used to combine result of two CompletableFuture
     *
     */
    private static void combineMethods() throws ExecutionException, InterruptedException {
        CompletableFuture<String> task = CompletableFuture.supplyAsync( () -> {
            IO.println("Supply Thread Name "+ Thread.currentThread().getName());
            try {
                Thread.sleep(1000); // increase time to get exception
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Nithesh ";
        }).orTimeout(2, TimeUnit.SECONDS);

        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync( () -> {
            IO.println("Supply Thread Name "+ Thread.currentThread().getName());
            return 8;
        }).orTimeout(2, TimeUnit.SECONDS);

        CompletableFuture<String> combine = task.thenCombine(task2, (val1, val2) -> val1 + val2);
        IO.println(combine.get());
    }


    /**
     * thenAccept returns void so no further chaining
     *
     */
    private static void acceptMethods() {

        CompletableFuture<String> task = CompletableFuture.supplyAsync( () -> {
            IO.println("Supply Thread Name "+ Thread.currentThread().getName());
            return "Nithesh ";
        });

        task.thenAccept((String val) -> {
            IO.println(val);
        });

        task.thenAcceptAsync((String val) -> {
            IO.println(val);
        });

    }


    /**
     * If there are multiple Async methods task sequence cannot be guaranteed
     * ThenCompose chain together in sequence to bring in ordering
     * when previous task is tied to next task.
     * ComposeAsync though it executes in a different thread sequence is taken care
     *
     */

    private static void composeMethods() {

        CompletableFuture<String> task = CompletableFuture.supplyAsync( () -> {
            IO.println("Supply Thread Name "+ Thread.currentThread().getName());
            return "Nithesh ";
        }).thenCompose((String val) -> {
            IO.println("Compose Thread Name "+ Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> val + "Kumar");
        });

        // Async

        CompletableFuture<String> asyncTask = CompletableFuture.supplyAsync( () -> {
            IO.println("Supply Thread Name "+ Thread.currentThread().getName());
            return "Nithesh ";
        }).thenComposeAsync((String val) -> {
            IO.println("Compose Thread Name "+ Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> val + "Kumar");
        }).thenComposeAsync((String val) -> {
            IO.println("Compose Thread Name 1 "+ Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> val + "Kumar");
        });
    }

    private static CompletableFuture<String> thenApplyAsyncExample() {

        CompletableFuture<String> task = CompletableFuture.supplyAsync( () -> {
            IO.println("Supply Thread Name "+ Thread.currentThread().getName());
            return "Nithesh ";
        }).thenApplyAsync((String val) -> {
            IO.println("Apply Thread Name "+ Thread.currentThread().getName());
            return val + "Kumar" ;
        });

        return task;

    }

    // Apply a function to the result of previous Async computation
    // Return a new CompletableFuture object
    // thenApply uses the same thread which completed the async task
    private static CompletableFuture<String>  thenApplyExample() {

        CompletableFuture<String> task = CompletableFuture.supplyAsync( () -> {
            return "Nithesh ";
        }).thenApply((String val) -> {
           return val + "Kumar" ;
        });

        return task;
    }

    private static CompletableFuture<String> supplyMethod() {

        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(
                () -> {
                    return "done";
                }
        );
        return task1;

    }

}
