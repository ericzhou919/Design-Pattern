## Definition

An object that can change its behavior when its internal state changes is allowed to modify its class.  

## Example

> An elephant, which is usually gentle, becomes angry when threatened.  

## Programmatic Example

Create State interface and implementation

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

Create Mammoth

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
