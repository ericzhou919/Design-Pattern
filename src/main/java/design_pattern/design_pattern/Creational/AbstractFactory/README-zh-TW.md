## 定義

提供一個建立一系列相關或互相依賴物件的介面，而無需指定它們具體的類別。  

## 例子   

> 食物工廠根據各種主食及肉類進行不同的搭配。    

|  | Beef |Pork|
|-------|:-----:|:------:|
| Noodles   |  BeefNoodles  |PorkNoodles|
| Rice   |  BeefRice  |   PorkRice |  
  
## 程式碼範例  
首先，建立食物的介面與實現。  
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

然後建立食物工廠的介面與實現。  
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

再來設計一個工廠，來使用不同的食物工廠。  
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

程式執行：  
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

輸出：  
```java
This is the Beef Noodles!
This is the Beef Rice!
This is the Pork Noodles!
This is the Pork Rice!
```
