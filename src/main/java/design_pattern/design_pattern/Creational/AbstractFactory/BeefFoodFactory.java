package design_pattern.design_pattern.Creational.AbstractFactory;

public class BeefFoodFactory implements FoodFactory {

    @Override
    public Noodles createNoodles() {
        return new BeefNoodles();
    }

    @Override
    public Rice createRice() {
        return new BeefRice();
    }
}