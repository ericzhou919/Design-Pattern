## Definition

An adapter converts the interface of a class into another interface that the client expects. It enables classes with incompatible interfaces to work together.

## Example

> Assuming we have a bird that makes sound chirp and a toy duck that makes sound squeak, and suddenly the customer wants the toy duck to make the bird's sound. In this case, we can simply use an adapter by passing the instance of the bird to the adapter.  

## Programmatic Example

Create the interface and implementation of the bird.

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

Create the interface and implementation of the toy duck.

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

Create Adapter。

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
