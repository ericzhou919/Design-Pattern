## 定義

訪問者模式是一種將演算法與對象結構分離的模式。  

## 例子   

> 一支軍隊的樹狀結構，訪問者模式使我們可以輕易創建新物件，與單獨或全部成員互動。  
  
## 程式碼範例  
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

```  

程式執行：  
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

輸出：  
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
