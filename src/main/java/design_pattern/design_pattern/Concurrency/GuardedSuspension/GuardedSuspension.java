package design_pattern.design_pattern.Concurrency.GuardedSuspension;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GuardedSuspension 
{
    public static void UseGuardedSuspension()
    {
        GuardedQueue guardedQueue = new GuardedQueue();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 2; i++) {
            executorService.execute(guardedQueue::get);
        }
        for (int i = 1; i < 3; i++) {
            try {
                Thread.sleep(2000*i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(() -> guardedQueue.put(20));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
