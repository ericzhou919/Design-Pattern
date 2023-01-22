## 定義

一種執行緒使用模式，執行緒池維護著多個執行緒，等待著監督管理者分配可並行執行的任務，這避免了在處理短時間任務時建立與銷毀執行緒的代價。

## 例子   

> 建立執行緒需要成本，若能重複使用已建立的執行緒，而不是用完就丟，可提昇效能。  
  
## 程式碼範例  
創建WorkerThread。
```java
public class WorkerThread implements Runnable {
    long startTime = System.currentTimeMillis();
    private String command;

    public WorkerThread(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private void processCommand() {
        try {
            int r = (int) (Math.random() * 5) + 1;
            Thread.sleep(r * 1000);
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            System.out.println("After "+ duration/1000+" seconds.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
```  

程式執行：  
```java
ExecutorService executor = Executors.newFixedThreadPool(5);
for (int i = 0; i < 10; i++) {
    Runnable worker = new WorkerThread("" + i);
    executor.execute(worker);
}
executor.shutdown();
while (!executor.isTerminated()) {
}
System.out.println("Finished all threads");
```  

輸出：  
```java
pool-1-thread-1 Start. Command = 0
pool-1-thread-2 Start. Command = 1
pool-1-thread-3 Start. Command = 2
pool-1-thread-4 Start. Command = 3
pool-1-thread-5 Start. Command = 4
```
After 1 seconds：  
```java
After 1 seconds.
pool-1-thread-4 End.
pool-1-thread-4 Start. Command = 5
```
After 2 seconds：  
```java
After 2 seconds.
pool-1-thread-1 End.
pool-1-thread-1 Start. Command = 6
After 2 seconds.
pool-1-thread-2 End.
pool-1-thread-2 Start. Command = 7
```
After 3 seconds：  
```java
After 3 seconds.
pool-1-thread-2 End.
pool-1-thread-2 Start. Command = 8
```
After 4 seconds：  
```java
After 4 seconds.
pool-1-thread-3 End.
pool-1-thread-3 Start. Command = 9
After 4 seconds.
pool-1-thread-5 End.
After 4 seconds.
pool-1-thread-4 End.
After 4 seconds.
pool-1-thread-3 End.
```
After 5 seconds：  
```java
After 5 seconds.
pool-1-thread-2 End.
```
After 6 seconds：  
```java
After 6 seconds.
pool-1-thread-1 End.
Finished all threads
```
