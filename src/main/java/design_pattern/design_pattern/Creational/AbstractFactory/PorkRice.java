package design_pattern.design_pattern.Creational.AbstractFactory;

public class PorkRice implements Rice {
    @Override
    public void getDescription() {
        System.out.println("This is the Pork Rice!");
    }
}