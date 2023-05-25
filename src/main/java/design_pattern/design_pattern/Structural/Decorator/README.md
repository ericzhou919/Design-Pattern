## Definition

Dynamically imposing responsibilities on objects provides a more flexible alternative to inheritance.  

## Example

> A couple is about to have a meal, but they don't have any utensils. To add utensils for them without creating new objects, you can dynamically decorate the utensils.  

## Programmatic Example

Create the People interface and implementation.

```java
public interface People {
    void startEating();
}

public class Man implements People {

  @Override
  public void startEating() {
    System.out.println("Man starting to eat.");
  }
}

public class Woman implements People {

  @Override
  public void startEating() {
    System.out.println("Woman starting to eat.");
  }
}
```

To add utensils for the couple.  

```java
public class PeopleWithFork implements People {

    private final People decorated;

    public PeopleWithFork(People decorated) {
        this.decorated = decorated;
    }

    @Override
    public void startEating() {
        System.out.println("");
        decorated.startEating();
        System.out.println("Eating With Fork.");
    }
}

public class PeopleWithChopsticks implements People {

    private final People decorated;

    public PeopleWithChopsticks(People decorated) {
        this.decorated = decorated;
    }

    @Override
    public void startEating() {
        System.out.println("");
        decorated.startEating();
        System.out.println("Eating With Chopsticks.");
    }
}
```

Program execution：

```java
Man m = new Man();
m.startEating();
System.out.println("A man is eating without utensils.");

PeopleWithChopsticks pwcm = new PeopleWithChopsticks(m);
pwcm.startEating();

PeopleWithFork pwfm = new PeopleWithFork(m);
pwfm.startEating();

System.out.println("");

Woman w = new Woman();
w.startEating();
System.out.println("A woman is eating without utensils.");

PeopleWithChopsticks pwcw = new PeopleWithChopsticks(w);
pwcw.startEating();

PeopleWithFork pwfw = new PeopleWithFork(w);
pwfw.startEating();
```

Program output：

```java
Man starting to eat.
A man is eating without utensils.

Man starting to eat.
Eating With Chopsticks.

Man starting to eat.
Eating With Fork.

Woman starting to eat.
A woman is eating without utensils.

Woman starting to eat.
Eating With Chopsticks.

Woman starting to eat.
Eating With Fork.
```
