## Definition

Visitor pattern is a pattern that separates algorithms from object structures.

## Example

> A tree structure of a military unit, the Visitor pattern allows us to easily create new objects and interact with individual or all members.

## Programmatic Example

Create Unit and UnitVisitor。

```java
public abstract class Unit {

    private final Unit[] children;

    public Unit(Unit... children) {
        this.children = children;
    }

    public void accept(UnitVisitor visitor) {
        Arrays.stream(children).forEach(child -> child.accept(visitor));
    }
}
public interface UnitVisitor {

    void visit(Soldier soldier);

    void visit(Sergeant sergeant);

    void visit(Commander commander);
}
```

Create unit members。

```java
public class Commander extends Unit {

    public Commander(Unit... children) {
        super(children);
    }
    @Override
    public void accept(UnitVisitor visitor) {
        visitor.visit(this);
        super.accept(visitor);
    }

    @Override
    public String toString() {
        return "commander";
    }
}

public class Sergeant extends Unit {
    public Sergeant(Unit... children) {
        super(children);
    }
    @Override
    public void accept(UnitVisitor visitor) {
        visitor.visit(this);
        super.accept(visitor);
    }

    @Override
    public String toString() {
        return "sergeant";
    }
}

public class Soldier extends Unit {
    public Soldier(Unit... children) {
        super(children);
    }
    @Override
    public void accept(UnitVisitor visitor) {
        visitor.visit(this);
        super.accept(visitor);
    }

    @Override
    public String toString() {
        return "soldier";
    }
}
```

Program execution：

```java
Commander commander = new Commander(
        new Sergeant(new Soldier(), new Soldier(), new Soldier()),
        new Sergeant(new Soldier(), new Soldier(), new Soldier()));

commander.accept(new SoldierVisitor());
System.out.println("");

commander.accept(new SergeantVisitor());
System.out.println("");

commander.accept(new CommanderVisitor());
```

Program output：

```java
Hello soldier
Hello soldier
Hello soldier
Hello soldier
Hello soldier
Hello soldier

Hello sergeant
Hello sergeant

Hello commander
```
