package learn.java.concepts.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreads {

    /**
     * Virtual Thread
     *
     * - To achieve higher throughput not latency
     * - JVM can create number of virtual threads and can attach to the OS thread for execution
     * - If a virtual thread has to wait then JVM will remove the link between OS thread
     * - this unblocks the OS thread for next execution
     *
     * Platform Threads
     *
     * - PT is managed by JVM but it's just a wrapper of OS thread
     * - It is slow since thread creation takes time
     * - Java calls OS for thread.start() which is system call so the latency
     * - if PT got an IO call in the instruction then till IO thread is blocked
     */

    static void main() throws ExecutionException, InterruptedException {

        ExecutorService virtualThreads = Executors.newVirtualThreadPerTaskExecutor();

        virtualThreads.submit( () -> {

            IO.println("Hi I'm running in virtual thread, my name is" + Thread.currentThread().getName());

        }).get();

    }

}
