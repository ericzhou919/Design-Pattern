## Definition

An object pool contains a set of pre-initialized and usable objects that can be created and destroyed as needed. Users can retrieve objects from the pool, perform operations on them, and return them to the pool when they're no longer needed instead of destroying them directly.

## Example

> In the gaming world, creating a giant costs a lot of resources, returning the resources to the pool after use, there's no need to create it again the next time it's used.

## Programmatic Example

Create Giants。

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

Create ObjectPool and GiantsPool。

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

Program execution：

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

Program output：

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
