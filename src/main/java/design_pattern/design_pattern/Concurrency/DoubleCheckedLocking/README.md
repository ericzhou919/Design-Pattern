## Definition

Double-checked locking is a practice of checking the state of a lazily initialized object both before and after entering a synchronized block to determine whether the object has been initialized.  

## Programmatic Example

Create DoubleCheckedLockingSingleton

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
