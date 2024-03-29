## Definition

將一個類別的接口轉換為客戶期望的另一個接口。Adapter 可以讓不相容介面的類別能夠一起工作。

## Example

> 假設我們有一隻鳥發出 A 聲音和玩具鴨發出 B 聲音，突然客戶希望玩具鴨能夠發出鳥的聲音，我們只需要使用適配器，將鳥的實例傳遞到適配器。

## Programmatic Example

創建鳥的介面及實作。

```java
public interface Bird {
    public void fly();

    public void makeSound();
}

public class Sparrow implements Bird {
    public void fly() {
        System.out.println("Flying");
    }

    public void makeSound() {
        System.out.println("Chirp Chirp");
    }
}
```

創建玩具鴨的介面及實作。

```java
public interface ToyDuck {
    public void squeak();
}

public class PlasticToyDuck implements ToyDuck {
    public void squeak() {
        System.out.println("Squeak");
    }
}
```

創建 Adapter。

```java
public class BirdAdapter implements ToyDuck {
    Bird bird;

    public BirdAdapter(Bird bird) {

        this.bird = bird;
    }

    public void squeak() {
        bird.makeSound();
    }
}
```

Program execution：

```java
Sparrow sparrow = new Sparrow();
System.out.println("Sparrow:");
sparrow.fly();
sparrow.makeSound();
System.out.println("");

ToyDuck toyDuck = new PlasticToyDuck();
System.out.println("ToyDuck:");
toyDuck.squeak();
System.out.println("");

ToyDuck birdAdapter = new BirdAdapter(sparrow);
System.out.println("BirdAdapter:");
birdAdapter.squeak();
```

Program output：

```java
Sparrow:
Flying
Chirp Chirp

ToyDuck:
Squeak

BirdAdapter:
Chirp Chirp
```
