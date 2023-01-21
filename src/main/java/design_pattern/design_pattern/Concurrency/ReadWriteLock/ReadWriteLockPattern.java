package design_pattern.design_pattern.Concurrency.ReadWriteLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ReadWriteLockPattern 
{
    public static void UseReadWriteLock()
    {
        ExecutorService executeService = Executors.newFixedThreadPool(10);
        ReaderWriterLock lock = new ReaderWriterLock();

        // Start writers
        for (int i = 0; i < 5; i++) {
            long  writingTime = ThreadLocalRandom.current().nextLong(5000);
            executeService.submit(new Writer("Writer " + i, lock.writeLock(), writingTime));
        }
        System.out.println("Writers added...");

        // Start readers
        for (int i = 0; i < 5; i++) {
            long readingTime = ThreadLocalRandom.current().nextLong(10);
            executeService.submit(new Reader("Reader " + i, lock.readLock(), readingTime));
        }
        System.out.println("Readers added...");

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            System.out.println("Error sleeping before adding more readers"+ e);
            Thread.currentThread().interrupt();
        }

        // Start readers
        for (int i = 6; i < 10; i++) {
            Long readingTime = ThreadLocalRandom.current().nextLong(10);
            executeService.submit(new Reader("Reader " + i, lock.readLock(), readingTime));
        }

        System.out.println("More readers added...");

        executeService.shutdown();
        try {
            executeService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            //LOGGER.error("Error waiting for ExecutorService shutdown", e);
            Thread.currentThread().interrupt();
        }
    }

}
