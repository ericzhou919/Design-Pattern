## 定義

定義了在某些演算法下的程式骨架，把某些行為或定義推遲到子類別實現，允許子類別在不改變算法結構的情況下重新定義算法的某些步驟。

## 例子   

>蓋房子有相同的步驟，根據不同的房子種類有不同的方法實現。  
  
## 程式碼範例  
創建模板方法和具體實現。
```java
public abstract class HouseTemplate {
    public final void buildHouse() {
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("House is built");
    }

    public abstract void buildWindows();

    public abstract void buildWalls();

    public abstract void buildPillars();

    private void buildFoundation() {
        System.out.println("Building foundation with cement,iron rods and sand");
    }
}
```   

創建含有模板方法的木屋及玻璃屋。
```java
public class WoodenHouse extends HouseTemplate {
    @Override
    public void buildWalls() {
        System.out.println("Building Wooden Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with Wood coating");
    }

    @Override
    public void buildWindows() {
        System.out.println("Building Wood Windows");
    }
}

public class GlassHouse extends HouseTemplate {

    @Override
    public void buildWalls() {
        System.out.println("Building Glass Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with glass coating");
    }
    @Override
    public void buildWindows() {
        System.out.println("Building Glass Windows");
    }
}
```  

程式執行：  
```java
HouseTemplate houseType = new WoodenHouse();
houseType.buildHouse();

System.out.println("");

houseType = new GlassHouse();
houseType.buildHouse();
```  

輸出：  
```java
Building foundation with cement,iron rods and sand
Building Pillars with Wood coating
Building Wooden Walls
Building Wood Windows
House is built

Building foundation with cement,iron rods and sand
Building Pillars with glass coating
Building Glass Walls
Building Glass Windows
House is built
```
