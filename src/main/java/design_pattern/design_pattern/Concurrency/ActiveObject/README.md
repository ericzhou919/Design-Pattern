[English](README.md) ∙ [繁體中文](README-zh-TW.md)

## Definition

Decouples method execution from method invocation for objects that each reside in their thread of control. The goal is to introduce concurrency, by using asynchronous method invocation, and a scheduler for handling requests. 
  
## Programmatic Example  
Create ActiveObject.
```java
public class ActiveObject {
  class Task implements Comparable<Task> {
    // smaller number means higher priority
    int priority;
    String name;

    Task(String name, int priority) {
      this.name = name;
      this.priority = priority;
    }

    public int compareTo(Task other) {
      return Integer.compare(this.priority, other.priority);
    }
  }

  private PriorityBlockingQueue<Task> dispatchQueue = new PriorityBlockingQueue<>();

  public ActiveObject() {
    new Thread(() -> {
      while (true) {
          try {
            Task task = dispatchQueue.take();
            System.out.println("Executing task " + task.name);
          } catch (InterruptedException e) {
            break;
          }
        }
    }).start();
  }

  public void doTask(String name, int priority) {
    System.out.println(Thread.currentThread().toString());
    dispatchQueue.put(new Task(name, priority));
  }
}

```  
 
Program execution：  
```java
ActiveObject obj = new ActiveObject();
Thread t1 = new Thread(() -> {
    obj.doTask("Third", 2);
});
Thread t2 = new Thread(() -> {
    obj.doTask("First", 0);
});
Thread t3 = new Thread(() -> {
    obj.doTask("Second", 1);
});
Thread.sleep(1000);
t1.start();
t2.start();
t3.start();
```  

Program output：  
```java
Thread[Thread-1,5,main]
Thread[Thread-2,5,main]
Thread[Thread-3,5,main]
Executing task First
Executing task Second
Executing task Third
```
