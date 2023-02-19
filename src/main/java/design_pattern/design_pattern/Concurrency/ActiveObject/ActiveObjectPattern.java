package design_pattern.design_pattern.Concurrency.ActiveObject;

import java.sql.Time;

public class ActiveObjectPattern {
    public static void UseActiveObject() throws InterruptedException {
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
    }
 
}
