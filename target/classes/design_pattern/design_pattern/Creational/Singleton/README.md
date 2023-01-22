## 定義

確保一個類別僅有一個實例，並提供一個存取它的全域存取點。   
  
## 程式碼範例  
建立SingletonObject。
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

程式執行：  
```java
SingletonObject s1 = SingletonObject.getInstance();
SingletonObject s2 = SingletonObject.getInstance();
System.out.println("s1:" + s1.hashCode());
System.out.println("s2:" + s2.hashCode());
```  

輸出：  
```java
s1:366712642
s2:366712642
```
