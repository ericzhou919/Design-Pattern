package design_pattern.design_pattern.Creational.AbstractFactory;

public class Food {
    Noodles noodles;
    
    public Noodles getNoodles() {
        return noodles;
    }
    public void setNoodles(Noodles noodles) {
        this.noodles = noodles;
    }

    Rice rice;
    
    public Rice getRice() {
        return rice;
    }

    public void setRice(Rice rice) {
        this.rice = rice;
    }
    
    public static class FactoryMaker {
        public enum MeatType {
            Beef, Pork
        }
        public static FoodFactory makeFactory(MeatType type) {
            switch (type) {
                case Beef:
                    return new BeefFoodFactory();
                case Pork:
                    return new PorkFoodFactory();
                default:
                    throw new IllegalArgumentException("MeatType not supported.");
            }
        }
    }
}