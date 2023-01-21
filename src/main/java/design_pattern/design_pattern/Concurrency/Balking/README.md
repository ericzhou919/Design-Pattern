## 定義

用於防止對像在處於不完整或不適當狀態時，阻止或拒絕請求。

## 例子   

> 洗衣機的按鈕，正常情況下會啟動洗衣機，但當洗衣機處於運轉中時，按鈕無效。  
  
## 程式碼範例  
建立洗衣機。
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
 
程式執行：  
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

輸出：  
```java
pool-1-thread-1: Actual machine state: ENABLED
pool-1-thread-1: Doing the washing

pool-1-thread-2: Actual machine state: WASHING
Cannot wash if the machine has been already washing!

pool-1-thread-3: Actual machine state: WASHING
Cannot wash if the machine has been already washing!

pool-1-thread-1: Washing completed.
```
