## Definition

雙重檢查鎖定，是在進入同步塊之前和之後檢查延遲初始化對象的狀態以確定是否初始化對象的一種實踐。

## Programmatic Example

創建 DoubleCheckedLockingSingleton。

```java
public class DoubleCheckedLockingSingleton{
    private static DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {
    }

    public static DoubleCheckedLockingSingleton getInstance() throws InterruptedException {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }
}
```

Program execution：

```java
DoubleCheckedLockingSingleton singleton1 = DoubleCheckedLockingSingleton.getInstance();
DoubleCheckedLockingSingleton singleton2 = DoubleCheckedLockingSingleton.getInstance();
System.out.println(singleton1 == singleton2);
```

Program output：

```java
true
```
