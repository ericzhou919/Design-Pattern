## 定義

定義一個用於建立物品的介面，讓子類決定實體化哪一個類別。工廠方法使一個類別的實例化延遲到其子類別。

## 例子   

> 硬幣工廠可以製造五元及十元等各種不同的硬幣，並且必須能夠在不修改現有源代碼的情況下在它們之間進行切換。  
  
## 程式碼範例  
建立硬幣的介面和不同硬幣種類的實現。
```java
public interface Coin {
    void getDescription();
}

public class FiveDollarCoin implements Coin {
    @Override
    public void getDescription() {
        System.out.println("This is a five dollar coin.");
    }
}

public class TenDollarCoin implements Coin {
    @Override
    public void getDescription() {
        System.out.println("This is a ten dollar coin.");
    }
}
```  

定義可製造的硬幣種類。  
```java
public enum CoinType {
    TEN, FIVE;
}
```  

設計一個工廠，創建封裝在工廠類中的硬幣對象。   
```java
public class CoinFactory {
    public Coin getCoin(CoinType _coinType) {
        if (_coinType.equals(CoinType.TEN)) {
            return new TenDollarCoin();
        } else if (_coinType.equals(CoinType.FIVE)) {
            return new FiveDollarCoin();
        }
        return null;
    }
}
```  

程式執行： 
```java
CoinFactory cf = new CoinFactory();
Coin coinTen = cf.getCoin(CoinType.TEN);
Coin coinFive = cf.getCoin(CoinType.FIVE);
coinTen.getDescription();
coinFive.getDescription();
```  

輸出：  
```java
This is a ten dollar coin.
This is a five dollar coin.
```
