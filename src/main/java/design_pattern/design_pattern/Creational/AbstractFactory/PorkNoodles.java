package design_pattern.design_pattern.Creational.AbstractFactory;

public class PorkNoodles implements Noodles {
    @Override
    public void getDescription() {
        System.out.println("This is the Pork Noodles!");
    }
}