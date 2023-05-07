## Definition

Define a series of algorithms and encapsulate them to allow them to be interchangeable with one another, enabling the algorithms to vary independently without affecting the clients that use them.

## Example

> 一位冒險者在遇到不同的怪物時，有不同的戰鬥策略。

## Programmatic Example

創建戰鬥策略介面及實現。

```java
public interface FightStrategy {
    void execute();
}
public class NormalAttack implements FightStrategy {
    @Override
    public void execute() {
        System.out.println("Use NormalAttack");
    }
}
public class SkillAttack implements FightStrategy {
    @Override
    public void execute() {
        System.out.println("Use SkillAttack");
    }
}
public class ItemAttack implements FightStrategy {
    @Override
    public void execute() {
        System.out.println("Use ItemAttack");
    }
}
```

創建冒險者。

```java
public class Adventurer {
    FightStrategy fightStrategy;

    public void attack() {
        if (fightStrategy == null) {
            fightStrategy = new NormalAttack();
        }
        fightStrategy.execute();
    }

    public void choiceStrategy(FightStrategy strategy) {
        this.fightStrategy = strategy;
    }
}
```

Program execution：

```java
Adventurer ad = new Adventurer();

System.out.println("Encounter normal monster");
ad.choiceStrategy(new NormalAttack());
ad.attack();

System.out.println("Encounter giant monster");
ad.choiceStrategy(new SkillAttack());
ad.attack();

System.out.println("Encounter special monster");
ad.choiceStrategy(new ItemAttack());
ad.attack();
```

Program output：

```java
Encounter normal monster
Use NormalAttack
Encounter giant monster
Use SkillAttack
Encounter special monster
Use ItemAttack
```
