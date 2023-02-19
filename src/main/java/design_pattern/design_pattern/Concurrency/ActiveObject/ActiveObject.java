package design_pattern.design_pattern.Concurrency.ActiveObject;

import java.util.concurrent.PriorityBlockingQueue;

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
