package design_pattern.design_pattern.Structural.Facade.CarSystem;

public class AirFlowController {

    private AirFlowMeter airFlowMeter = new AirFlowMeter();

    public void takeAir() {
        airFlowMeter.getMeasurements();
        System.out.println("Air provided!");
    }

    public void off() {
        System.out.println("Air controller switched off.");
    }
}
