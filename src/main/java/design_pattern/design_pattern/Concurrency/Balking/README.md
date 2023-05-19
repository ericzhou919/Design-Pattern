## Definition

Used to prevent or reject requests when an object is in an incomplete or inappropriate state.

## Example

> Washing Machine button, starting the machine under normal conditions, but when the machine is running, button invalid.

## Programmatic Example

Create WashingMachine。

```java
public enum WashingMachineState {
    ENABLED,
    WASHING
}

public interface DelayProvider {
  void executeAfterDelay(long interval, TimeUnit timeUnit, Runnable task);
}

public class WashingMachine {

    private final DelayProvider delayProvider;
    private WashingMachineState washingMachineState;

    public WashingMachine() {
        this((interval, timeUnit, task) -> {
            try {
                Thread.sleep(timeUnit.toMillis(interval));
            } catch (InterruptedException ie) {
                System.out.println(ie);
                Thread.currentThread().interrupt();
            }
            task.run();
        });
    }

    public WashingMachine(DelayProvider delayProvider) {
        this.delayProvider = delayProvider;
        this.washingMachineState = WashingMachineState.ENABLED;
    }

    public WashingMachineState getWashingMachineState() {
        return washingMachineState;
    }

    public void wash() {
        synchronized (this) {
            WashingMachineState machineState = getWashingMachineState();
            System.out.println(Thread.currentThread().getName() + ": Actual machine state: " + machineState);
            if (this.washingMachineState == WashingMachineState.WASHING) {
                System.out.println("Cannot wash if the machine has been already washing!");
                System.out.println("");
                return;
            }
            this.washingMachineState = WashingMachineState.WASHING;
        }
        System.out.println(Thread.currentThread().getName() + ": Doing the washing");
        System.out.println("");

        this.delayProvider.executeAfterDelay(50, TimeUnit.MILLISECONDS, this::endOfWashing);
    }

    public synchronized void endOfWashing() {
        washingMachineState = WashingMachineState.ENABLED;
        System.out.println(Thread.currentThread().getName() + ": Washing completed.");
    }
}
```

Program execution：

```java
final WashingMachine washingMachine = new WashingMachine();
ExecutorService executorService = Executors.newFixedThreadPool(3);
for (int i = 0; i < 3; i++) {
    executorService.execute(washingMachine::wash);
}
executorService.shutdown();
try {
    if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
        executorService.shutdownNow();
    }
} catch (InterruptedException ie) {
    System.out.println("ERROR: Waiting on executor service shutdown!");
    Thread.currentThread().interrupt();
}
```

Program output：

```java
pool-1-thread-1: Actual machine state: ENABLED
pool-1-thread-1: Doing the washing

pool-1-thread-2: Actual machine state: WASHING
Cannot wash if the machine has been already washing!

pool-1-thread-3: Actual machine state: WASHING
Cannot wash if the machine has been already washing!

pool-1-thread-1: Washing completed.
```
