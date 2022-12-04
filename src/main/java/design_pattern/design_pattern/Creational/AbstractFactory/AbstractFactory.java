package design_pattern.design_pattern.Creational.AbstractFactory;

public class AbstractFactory 
{
    private final static Food food = new Food();
    public static void UseAbstractFactory()
    {
        createFood(Food.FactoryMaker.MeatType.Beef);
        food.getNoodles().getDescription();
        food.getRice().getDescription();
        
        createFood(Food.FactoryMaker.MeatType.Pork);
        food.getNoodles().getDescription();
        food.getRice().getDescription();
    }
    
    public static void createFood(final Food.FactoryMaker.MeatType type) {
        final FoodFactory foodFactory = Food.FactoryMaker.makeFactory(type);
        food.setNoodles(foodFactory.createNoodles());
        food.setRice(foodFactory.createRice());
    }
}
