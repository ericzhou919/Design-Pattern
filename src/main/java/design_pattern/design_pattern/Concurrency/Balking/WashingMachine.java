package design_pattern.design_pattern.Concurrency.Balking;

import java.util.concurrent.TimeUnit;

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