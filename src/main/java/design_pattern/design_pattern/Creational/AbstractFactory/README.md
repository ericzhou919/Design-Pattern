## 定義

提供一個建立一系列相關或互相依賴物件的介面，而無需指定它們具體的類別。

## 例子   

> 食物工廠根據各種主食及肉類進行不同的搭配  

|  | Beef |Pork|
|-------|:-----:|:------:|
| Noodles   |  BeefNoodles  |PorkNoodles|
| Rice   |  BeefRice  |   PorkRice |  
  
## 程式碼範例  
```java
public interface Rice {
    void getDescription();
}

public interface Noodles {
    void getDescription();
}

public class BeefRice implements Rice {
    @Override
    public void getDescription() {
        System.out.println("This is the Beef Rice!");
    }
}
public class BeefRice implements Rice {
    @Override
    public void getDescription() {
        System.out.println("This is the Beef Rice!");
    }
}

```
