## Definition

允許一個對像在其內部狀態改變時改變它的行為，該對像會更改其類別。

## Example

> 一隻長毛象，平時很溫和，當受到威脅時，會變得憤怒。

## Programmatic Example

建立 State 介面及實作。

```java
public interface State {

    void onEnterState();

    void observe();
}

public class PeacefulState implements State {

  private final Mammoth mammoth;

  public PeacefulState(Mammoth mammoth) {
    this.mammoth = mammoth;
  }

  @Override
  public void observe() {
    System.out.println(mammoth + " is calm and peaceful.");
  }

  @Override
  public void onEnterState() {
    System.out.println(mammoth + " calms down.");
  }
}

public class AngryState implements State {

  private final Mammoth mammoth;

  public AngryState(Mammoth mammoth) {
    this.mammoth = mammoth;
  }

  @Override
  public void observe() {
    System.out.println(mammoth + " is furious!");
  }

  @Override
  public void onEnterState() {
    System.out.println(mammoth + " gets angry!");
  }
}
```

建立 Mammoth。

```java
public class Mammoth {

  private State state;

  public Mammoth() {
    state = new PeacefulState(this);
  }

  public void timePasses() {
    if (state.getClass().equals(PeacefulState.class)) {
      changeStateTo(new AngryState(this));
    } else {
      changeStateTo(new PeacefulState(this));
    }
  }

  private void changeStateTo(State newState) {
    this.state = newState;
    this.state.onEnterState();
  }

  @Override
  public String toString() {
    return "The mammoth";
  }

  public void observe() {
    this.state.observe();
  }
}
```

Program execution：

```java
Mammoth mammoth = new Mammoth();
mammoth.observe();
mammoth.timePasses();
mammoth.observe();
mammoth.timePasses();
mammoth.observe();
```

Program output：

```java
The mammoth is calm and peaceful.
The mammoth gets angry!
The mammoth is furious!
The mammoth calms down.
The mammoth is calm and peaceful.
```
