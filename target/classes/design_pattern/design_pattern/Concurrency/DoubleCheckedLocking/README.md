## 定義

雙重檢查鎖定，是在進入同步塊之前和之後檢查延遲初始化對象的狀態以確定是否初始化對象的一種實踐。
  
## 程式碼範例  
創建DoubleCheckedLockingSingleton。
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

程式執行：  
```java
DoubleCheckedLockingSingleton singleton1 = DoubleCheckedLockingSingleton.getInstance();
DoubleCheckedLockingSingleton singleton2 = DoubleCheckedLockingSingleton.getInstance();
System.out.println(singleton1 == singleton2); 
```  

輸出：  
```java
true
```
