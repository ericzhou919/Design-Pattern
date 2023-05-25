## Definition

Read-write locks are used to protect shared resources during read and write access. Read locks allow multiple readers to access the shared resource simultaneously, but when a writer is writing, other readers and writers must wait. This helps avoid inconsistencies in the shared resource during write operations.  

## Programmatic Example

Create Reader.  

```java
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
```

Create Writer.

```java
public class Writer implements Runnable {

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
```

Create ReaderWriterLock.

```java
public class ReaderWriterLock implements ReadWriteLock {

    private final Object readerMutex = new Object();

    private int currentReaderCount;

    private final Set<Object> globalMutex = new HashSet<>();

    private final ReadLock readerLock = new ReadLock();
    private final WriteLock writerLock = new WriteLock();

    @Override
    public Lock readLock() {
        return readerLock;
    }

    @Override
    public Lock writeLock() {
        return writerLock;
    }
    private boolean doesWriterOwnThisLock() {
        return globalMutex.contains(writerLock);
    }
    private boolean isLockFree() {
        return globalMutex.isEmpty();
    }
    private class ReadLock implements Lock {

        @Override
        public void lock() {
            synchronized (readerMutex) {
                currentReaderCount++;
                if (currentReaderCount == 1) {
                    acquireForReaders();
                }
            }
        }

        private void acquireForReaders() {
            synchronized (globalMutex) {
                while (doesWriterOwnThisLock()) {
                    try {
                        globalMutex.wait();
                    } catch (InterruptedException e) {
                        System.out.println(
                                "InterruptedException while waiting for globalMutex in acquireForReaders" + e);
                        Thread.currentThread().interrupt();
                    }
                }
                globalMutex.add(this);
            }
        }

        @Override
        public void unlock() {
            synchronized (readerMutex) {
                currentReaderCount--;
                if (currentReaderCount == 0) {
                    synchronized (globalMutex) {
                        globalMutex.remove(this);
                        globalMutex.notifyAll();
                    }
                }
            }

        }

        @Override
        public void lockInterruptibly() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean tryLock() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean tryLock(long time, TimeUnit unit) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Condition newCondition() {
            throw new UnsupportedOperationException();
        }

    }
    private class WriteLock implements Lock {

        @Override
        public void lock() {
            synchronized (globalMutex) {

                while (!isLockFree()) {
                    try {
                        globalMutex.wait();
                    } catch (InterruptedException e) {
                        System.out.println("InterruptedException while waiting for globalMutex to begin writing"+ e);
                        Thread.currentThread().interrupt();
                    }
                }
                globalMutex.add(this);
            }
        }

        @Override
        public void unlock() {
            synchronized (globalMutex) {
                globalMutex.remove(this);
                globalMutex.notifyAll();
            }
        }

        @Override
        public void lockInterruptibly() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean tryLock() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean tryLock(long time, TimeUnit unit) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Condition newCondition() {
            throw new UnsupportedOperationException();
        }
    }

}

```

Program execution：

```java
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
```

Program output：

```java
Writer 0 begin
Writers added...
Readers added...
Writer 0 finished after writing 3666ms
Reader 0begin
Reader 4begin
Reader 3begin
Reader 2begin
Reader 1begin
Reader 4 finish after reading 2ms
Reader 2 finish after reading 3ms
Reader 0 finish after reading 6ms
Reader 3 finish after reading 6ms
Reader 1 finish after reading 0ms
Writer 1 begin
More readers added...
Writer 1 finished after writing 1366ms
Reader 6begin
Reader 9begin
Reader 8begin
Reader 7begin
Reader 8 finish after reading 2ms
Reader 9 finish after reading 4ms
Reader 7 finish after reading 9ms
Reader 6 finish after reading 9ms
Writer 2 begin
Writer 2 finished after writing 353ms
Writer 4 begin
Writer 4 finished after writing 704ms
Writer 3 begin
Writer 3 finished after writing 166ms
```
