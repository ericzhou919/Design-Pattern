package design_pattern.design_pattern.Concurrency.ThreadPool;

import java.util.Random;


public class ThreadPoolPattern 
{
    public static void UseThreadPool() throws InterruptedException
    {
        ThreadPool threadPool = new ThreadPool(5);
        Random random = new Random();

        for (int i=0; i<10; i++) {
            int fi = i;
            threadPool.execute(() -> {
                try {
                    Thread.sleep(random.nextInt(1000));
                    System.out.printf("task %d complete\n", fi);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        Thread.sleep(3000);
        threadPool.shutdown();
 
        
    }

}
