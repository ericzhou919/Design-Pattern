package design_pattern.design_pattern.Concurrency.ReadWriteLock;



import java.util.concurrent.locks.Lock;


public class Reader implements Runnable {

    private final Lock readLock;

    private final String name;

    private final long readingTime;


    public Reader(String name, Lock readLock, long readingTime) {
        this.name = name;
        this.readLock = readLock;
        this.readingTime = readingTime;
    }


    public Reader(String name, Lock readLock) {
        this(name, readLock, 250L);
    }

    @Override
    public void run() {
        readLock.lock();
        try {
            read();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException when reading"+ e);
            Thread.currentThread().interrupt();
        } finally {
            readLock.unlock();
        }
    }

    public void read() throws InterruptedException {
        System.out.println(name+"begin");
        Thread.sleep(readingTime);
        System.out.println(name+" finish after reading "+ readingTime+"ms");
    }
}
