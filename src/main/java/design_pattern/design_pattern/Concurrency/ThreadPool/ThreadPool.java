package design_pattern.design_pattern.Concurrency.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool implements Runnable{
    private final LinkedBlockingQueue<Runnable> queue;
    private final List<Thread> threads;
    private boolean shutdown;

    public ThreadPool(int numberOfThreads) {
        queue = new LinkedBlockingQueue<>();
        threads = new ArrayList<>();

        for (int i=0; i<numberOfThreads; i++) {
            Thread thread = new Thread(this);
            thread.start();
            threads.add(thread);
        }
    }

    public void execute(Runnable task) throws InterruptedException {
        queue.put(task);
    }

    private Runnable consume() throws InterruptedException {
        return queue.take();
    }

    public void run()  {
        try {
            while (!shutdown) {
                Runnable task = this.consume();
                task.run();
            }
        } catch(InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + " shutdown");
    }

    public void shutdown() {
        shutdown = true;

        threads.forEach((thread) -> {
            thread.interrupt();
        });
    }
}
