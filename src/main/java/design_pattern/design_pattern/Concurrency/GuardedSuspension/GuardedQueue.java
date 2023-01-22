package design_pattern.design_pattern.Concurrency.GuardedSuspension;

import java.util.LinkedList;
import java.util.Queue;

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