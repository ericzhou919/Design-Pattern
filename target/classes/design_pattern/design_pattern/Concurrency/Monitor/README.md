## Definition

用於創建執行緒安全的物件，並防止併發應用程序中線程之間的衝突。

## Example

> 一群人想參觀一間房子，但同一時間只能有一個人能進入房子參觀。

## Programmatic Example

創建訪客及房子。

```java
public class Visitor implements Runnable {
  private VisitableHouse house;
  private String name;

  public Visitor(VisitableHouse house, String name) {
    this.house = house;
    this.name = name;
  }

  @Override
  public void run() {
    this.house.visit(this.name);
  }
}

public class VisitableHouse {

  private Object visit = new Object();

  public void visit(String visitor) {
    System.out.println(visitor+" is waiting for the visit");
    synchronized(visit) {
      try {
        Thread.sleep(1000);
        System.out.println(visitor+" is visited the house");
      } catch (Exception e) {
        e.printStackTrace();
      }
    };
  }
}
```

Program execution：

```java
VisitableHouse house = new VisitableHouse();
Thread visitor1 = new Thread(new Visitor(house, "visitor#1"));
Thread visitor2 = new Thread(new Visitor(house, "visitor#2"));
Thread visitor3 = new Thread(new Visitor(house, "visitor#3"));
Thread visitor4 = new Thread(new Visitor(house, "visitor#4"));
Thread visitor5 = new Thread(new Visitor(house, "visitor#5"));
visitor1.start();
visitor2.start();
visitor3.start();
visitor4.start();
visitor5.start();
```

Program output：

```java
visitor#2 is waiting for the visit
visitor#5 is waiting for the visit
visitor#4 is waiting for the visit
visitor#1 is waiting for the visit
visitor#3 is waiting for the visit
```

After 1 seconds：

```java
visitor#2 is visited the house
```

After 2 seconds：

```java
visitor#3 is visited the house
```

After 3 seconds：

```java
visitor#1 is visited the house
```

After 4 seconds：

```java
visitor#4 is visited the house
```

After 5 seconds：

```java
visitor#5 is visited the house
```
