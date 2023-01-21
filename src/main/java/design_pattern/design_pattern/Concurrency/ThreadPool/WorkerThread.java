package design_pattern.design_pattern.Concurrency.ThreadPool;

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
            int r = (int) (Math.random() * 6) + 2;
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