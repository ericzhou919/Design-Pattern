package design_pattern.design_pattern.Concurrency.ReadWriteLock;


import java.util.concurrent.locks.Lock;


public class Writer implements Runnable {

    private final Lock writeLock;

    private final String name;

    private final long writingTime;

    public Writer(String name, Lock writeLock) {
        this(name, writeLock, 250L);
    }

    public Writer(String name, Lock writeLock, long writingTime) {
        this.name = name;
        this.writeLock = writeLock;
        this.writingTime = writingTime;
    }

    @Override
    public void run() {
        writeLock.lock();
        try {
            write();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException when writing"+ e);
            Thread.currentThread().interrupt();
        } finally {
            writeLock.unlock();
        }
    }


    public void write() throws InterruptedException {
        System.out.println(name+" begin");
        Thread.sleep(writingTime);
        System.out.println(name+" finished after writing "+writingTime+"ms");
    }
}