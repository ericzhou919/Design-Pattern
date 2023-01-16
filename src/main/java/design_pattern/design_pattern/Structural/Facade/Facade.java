package design_pattern.design_pattern.Structural.Facade;

public class Facade {
    public static void UseFacade() {
        CarEngineFacade c = new CarEngineFacade();
        c.startEngine();
        System.out.println("");
        c.stopEngine();
    }
}