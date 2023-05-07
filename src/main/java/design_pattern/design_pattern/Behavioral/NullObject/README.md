## Definition

提供一個給定類型的空對象代理，這個空對像不執行任何動作，對他的合作對象隱藏細節。

## Example

> Null Object Pattern 中，Null 對像不是檢查空值，而是反應一個不做任何動作的關係。

## Programmatic Example

Create AbstractCustomer。

```java
public abstract class AbstractCustomer {
    protected String name;

    public abstract boolean isNull();

    public abstract String getName();
}
```

實作 RealCustomer。

```java
public class RealCustomer extends AbstractCustomer {

    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isNull() {
        return false;
    }
}
```

實作 NullCustomer。

```java
public class NullCustomer extends AbstractCustomer {

    @Override
    public String getName() {
        return "Not Available in Customer Database";
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
```

Create CustomerFactory。

```java
public class CustomerFactory {

    public static final String[] names = { "A", "B", "C" };

    public static AbstractCustomer getCustomer(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}
```

Program execution：

```java
// names = { "A", "B", "C" };
AbstractCustomer customer1 = CustomerFactory.getCustomer("A");
AbstractCustomer customer2 = CustomerFactory.getCustomer("D");
AbstractCustomer customer3 = CustomerFactory.getCustomer("B");
AbstractCustomer customer4 = CustomerFactory.getCustomer("E");

System.out.println(customer1.getName());
System.out.println(customer2.getName());
System.out.println(customer3.getName());
System.out.println(customer4.getName());
```

Program output：

```java
A
Not Available in Customer Database
B
Not Available in Customer Database
```
