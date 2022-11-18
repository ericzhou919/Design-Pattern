package design_pattern.design_pattern.Creational.ObjectPool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Hello world!
 *
 */
public class Giants {
    private static final AtomicInteger counter = new AtomicInteger(0);

    private final int id;

    public Giants() {
        id = counter.incrementAndGet();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Giants id=%d", id);
    }
}
