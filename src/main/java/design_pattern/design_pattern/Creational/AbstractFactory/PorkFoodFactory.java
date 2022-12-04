package design_pattern.design_pattern.Creational.AbstractFactory;

public class PorkFoodFactory implements FoodFactory {

    @Override
    public Noodles createNoodles() {
        return new PorkNoodles();
    }

    @Override
    public Rice createRice() {
        return new PorkRice();
    }
}