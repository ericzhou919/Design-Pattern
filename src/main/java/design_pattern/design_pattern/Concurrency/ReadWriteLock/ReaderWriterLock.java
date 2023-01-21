package design_pattern.design_pattern.Concurrency.ReadWriteLock;



import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

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
