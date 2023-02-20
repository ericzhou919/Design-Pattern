## Definition

Provide an interface for creating families of related or dependent objects without specifying their concrete classes.    

## Example   

> The food factory creates different combinations of food based on various types of staple foods and meats.    

|  | Beef |Pork|
|-------|:-----:|:------:|
| Noodles   |  BeefNoodles  |PorkNoodles|
| Rice   |  BeefRice  |   PorkRice |  
  
## Programmatic Example  
First, create the interface and implementation for the food.  
```java
public interface Rice {
    void getDescription();
}

public interface Noodles {
    void getDescription();
}

public class BeefRice implements Rice {
    @Override
    public void getDescription() {
        System.out.println("This is the Beef Rice!");
    }
}
public class BeefNoodles implements Noodles {
    @Override
    public void getDescription() {
        System.out.println("This is the Beef Noodles!");
    }
}
```  

Then, create the interface and implementation for the food factory.  
```java
public interface FoodFactory {
    Noodles createNoodles();
    Rice createRice();
}

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
```  

Next, design a factory that uses different food factories.  
```java
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
```  

Program execution：  
```java
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
```  

Program output：  
```java
This is the Beef Noodles!
This is the Beef Rice!
This is the Pork Noodles!
This is the Pork Rice!
```
