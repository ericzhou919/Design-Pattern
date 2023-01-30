## 定義

。  

## 例子   

> 。  
  
## 程式碼範例  
。
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

。
```java

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
