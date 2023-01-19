## 定義

用於創建執行緒安全的物件，並防止併發應用程序中線程之間的衝突。 　

## 例子   

> 一群人想租一間房子，但同一時間只能有一個人進入房子參觀。  
  
## 程式碼範例  
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

程式執行： 
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

輸出：  
```java
visitor#2 is waiting for the visit
visitor#5 is waiting for the visit
visitor#4 is waiting for the visit
visitor#1 is waiting for the visit
visitor#3 is waiting for the visit
```
一秒後：  
```java
visitor#2 is visited the house
```
兩秒後：  
```java
visitor#3 is visited the house
```
三秒後：  
```java
visitor#1 is visited the house
```
四秒後：  
```java
visitor#4 is visited the house
```
五秒後：  
```java
visitor#5 is visited the house
```
