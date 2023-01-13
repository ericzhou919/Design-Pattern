## 定義

提供一個給定類型的空對象代理，這個空對像不執行任何動作，對他的合作對象隱藏細節。

## 例子   

> Null Object Pattern中，Null 對像不是檢查空值，而是反應一個不做任何動作的關係。  
  
## 程式碼範例  
創建AbstractCustomer。
```java
public abstract class AbstractCustomer {
    protected String name;

    public abstract boolean isNull();

    public abstract String getName();
}
```  

實作RealCustomer。  
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

實作NullCustomer。  
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

創建CustomerFactory。
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
程式執行：  
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

輸出：  
```java
A
Not Available in Customer Database
B
Not Available in Customer Database
```
