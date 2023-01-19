package design_pattern.design_pattern.Concurrency.ActiveObject;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class ActiveCreature {

    private BlockingQueue<Runnable> requests;

    private String name;

    private Thread thread;

    public ActiveCreature(String name) {
        this.name = name;
        this.requests = new LinkedBlockingQueue<Runnable>();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        requests.take().run();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        });
        thread.start();
    }

    public void eat() throws InterruptedException {
        requests.put(new Runnable() {
            @Override
            public void run() {
                System.out.println(name() + " is eating!");
                System.out.println(name() + " has finished eating!");
            }
        });
    }

    public void roam() throws InterruptedException {
        requests.put(new Runnable() {
            @Override
            public void run() {
                System.out.println(name()+" has started to roam the wastelands.");
            }
        });
    }

    public String name() {
        return this.name;
    }
}