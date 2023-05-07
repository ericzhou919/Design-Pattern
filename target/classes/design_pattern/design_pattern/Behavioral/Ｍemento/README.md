## Definition

Capture the internal state of an object without violating encapsulation, and save the state externally so that the object can be restored to its previous state later on.

## Example

> Memento Pattern consists of two objects: Originator and Caretaker. The Originator is an object with internal state. The Caretaker performs operations on the Originator but can undo changes when necessary. For example, in a word editor, the editor is the Caretaker and the content text is the Originator.

## Programmatic Example

Create Memento。

```java
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
```

Create Originator。

```java
public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
```

Create CareTaker。

```java
import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
```

Program execution：

```java
Originator originator = new Originator();
CareTaker careTaker = new CareTaker();

originator.setState("State #1");
originator.setState("State #2");
careTaker.add(originator.saveStateToMemento());

originator.setState("State #3");
careTaker.add(originator.saveStateToMemento());

originator.setState("State #4");
System.out.println("Current State: " + originator.getState());

originator.getStateFromMemento(careTaker.get(0));
System.out.println("First saved State: " + originator.getState());
originator.getStateFromMemento(careTaker.get(1));
System.out.println("Second saved State: " + originator.getState());
```

Program output：

```java
Current State: State #4
First saved State: State #2
Second saved State: State #3
```
