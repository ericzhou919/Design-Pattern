## 定義

物件池包含一組已經初始化過且可以使用的物件，而可以在有需求時創建和銷毀物件。使用者可以從池子中取得物件，對其進行操作處理，並在不需要時歸還給池子而非直接銷毀它。

## 例子   

> 在遊戲世界裡，創建巨人的成本非常高，使用完將資源丟回池，下次使用時就不需要再次創建。  
  
## 程式碼範例  
建立Giants。
```java
public class Giants {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final int id;
    public Giants() {
        id = counter.incrementAndGet();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return String.format("Giants id=%d", id);
    }
}
```  

建立ObjectPool和GiantsPool。
```java
public abstract class ObjectPool<T> {

    private final Set<T> available = new HashSet<>();
    private final Set<T> inUse = new HashSet<>();

    protected abstract T create();

    public synchronized T acquire() {
        if (available.isEmpty()) {
            available.add(create());
        }
        T instance = available.iterator().next();
        available.remove(instance);
        inUse.add(instance);
        return instance;
    }

    public synchronized void release(T instance) {
        inUse.remove(instance);
        available.add(instance);
    }

    @Override
    public synchronized String toString() {
        return String.format("Pool available=%d inUse=%d", available.size(), inUse.size());
    }
}

public class GiantsPool extends ObjectPool<Giants> {

    @Override
    protected Giants create() {
        return new Giants();
    }
}
```  

程式執行：  
```java
GiantsPool gp = new GiantsPool();
System.out.println(gp.toString());
Giants g1 = gp.acquire();
System.out.println(g1.toString());
Giants g2 = gp.acquire();
System.out.println(g2.toString());
Giants g3 = gp.acquire();
System.out.println(g3.toString());
System.out.println("before release " + gp.toString());
gp.release(g1);
System.out.println("release g1");
gp.release(g2);
System.out.println("release g2");
System.out.println("after release " + gp.toString());
Giants g4 = gp.acquire();
System.out.println(g4.toString());
Giants g5 = gp.acquire();
System.out.println(g5.toString());
System.out.println("after acquire " + gp.toString());
```  

輸出：  
```java
Pool available=0 inUse=0
Giants id=1
Giants id=2
Giants id=3
before release Pool available=0 inUse=3
release g1
release g2
after release Pool available=2 inUse=1
Giants id=2
Giants id=1
after acquire Pool available=0 inUse=3
```
