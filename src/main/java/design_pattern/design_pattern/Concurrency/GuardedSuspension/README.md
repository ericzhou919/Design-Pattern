## Definition

用於管理在執行操作之前需要獲取鎖和滿足先決條件的操作。

## Programmatic Example

創建 GuardedQueue。

```java
public class GuardedQueue {
    private final Queue<Integer> sourceList;

    public GuardedQueue() {
        this.sourceList = new LinkedList<>();
    }

    public synchronized Integer get() {
        while (sourceList.isEmpty()) {
            try {
                System.out.println("Waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Getting");
        return sourceList.peek();
    }

    public synchronized void put(Integer e) {
        System.out.println("Putting");
        sourceList.add(e);
        System.out.println("Notifying");
        notify();
    }
}
```

Program execution：

```java
GuardedQueue guardedQueue = new GuardedQueue();
ExecutorService executorService = Executors.newFixedThreadPool(3);

for (int i = 0; i < 2; i++) {
    executorService.execute(guardedQueue::get);
}
for (int i = 1; i < 3; i++) {
    try {
        Thread.sleep(2000*i);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    executorService.execute(() -> guardedQueue.put(20));
}

executorService.shutdown();
try {
    executorService.awaitTermination(30, TimeUnit.SECONDS);
} catch (InterruptedException e) {
    e.printStackTrace();
}
```

Program output：

```java
Waiting
Waiting
```

After 2 seconds：

```java
Putting
Notifying
Getting
```

After 4 seconds：

```java
Putting
Notifying
Getting
```
