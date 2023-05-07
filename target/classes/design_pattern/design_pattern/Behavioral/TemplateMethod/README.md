## Definition

This refers to the Template Method pattern which defines the skeleton of an algorithm in which certain behaviors or definitions are deferred to subclasses. This allows subclasses to redefine certain steps of the algorithm without changing its structure.

## Example

> Building a house involves the same steps, but there are different methods to implement based on the type of house.

## Programmatic Example

Create a template method and implementation.

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

Create wooden and glass houses that contain a template method.

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

Program execution：

```java
HouseTemplate houseType = new WoodenHouse();
houseType.buildHouse();

System.out.println("");

houseType = new GlassHouse();
houseType.buildHouse();
```

Program output：

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
