## Definition

Provide a null object proxy for a given type that doesn't perform any actions and hides the details from its collaborators.  

## Example

> In the Null Object Pattern, the Null object is not about checking for null values but rather represents a relationship that does nothing.  

## Programmatic Example

Create AbstractCustomer。

```java
public abstract class AbstractCustomer {
    protected String name;

    public abstract boolean isNull();

    public abstract String getName();
}
```

Implement RealCustomer.

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

Implement NullCustomer.

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
