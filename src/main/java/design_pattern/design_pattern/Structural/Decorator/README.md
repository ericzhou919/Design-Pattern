## 定義

動態地將責任加諸於物件上，提供比繼承更有彈性的替代方案。  

## 例子   

> 一對男女正要用餐，但沒有餐具，要為他們新增餐具，不需要創建新的物件，而是用餐具動態地裝飾。  
  
## 程式碼範例  
創建People介面及實作。
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

為男女添加餐具。
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

程式執行：  
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

輸出：  
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
