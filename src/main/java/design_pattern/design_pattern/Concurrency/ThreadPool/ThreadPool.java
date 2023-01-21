package design_pattern.design_pattern.Concurrency.ThreadPool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadPool
{
    public static void UseThreadPool() throws InterruptedException
    {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

}
