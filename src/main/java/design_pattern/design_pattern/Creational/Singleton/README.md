## Definition

Ensure that a class has only one instance and provide a global access point to it.

## Programmatic Example

Create SingletonObject。

```java
public class SingletonObject
{
    private static SingletonObject instance;

    private SingletonObject() {}

    public static SingletonObject getInstance() {
        if (instance == null) {
            instance = new SingletonObject();
        }
        return instance;
    }
}
```

Program execution：

```java
SingletonObject s1 = SingletonObject.getInstance();
SingletonObject s2 = SingletonObject.getInstance();
System.out.println("s1:" + s1.hashCode());
System.out.println("s2:" + s2.hashCode());
```

Program output：

```java
s1:366712642
s2:366712642
```
