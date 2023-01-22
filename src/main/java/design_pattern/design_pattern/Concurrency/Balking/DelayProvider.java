package design_pattern.design_pattern.Concurrency.Balking;

import java.util.concurrent.TimeUnit;

public interface DelayProvider {
    void executeAfterDelay(long interval, TimeUnit timeUnit, Runnable task);
}
