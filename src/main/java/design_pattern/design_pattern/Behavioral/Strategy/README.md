## 定義

定義一系列演算法，並將其封裝起來，使他們可以相互替換，讓演算法在不影響使用它的客戶端的情況下獨立變化。

## 例子   

>一位冒險者在遇到不同的怪物時，有不同的戰鬥策略。  
  
## 程式碼範例  
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

程式執行：  
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

輸出：  
```java
Encounter normal monster
Use NormalAttack
Encounter giant monster
Use SkillAttack
Encounter special monster
Use ItemAttack
```
