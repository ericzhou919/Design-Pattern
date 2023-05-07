## Definition

Define an interface for creating objects and let the subclass decide which class to instantiate. The Factory Method pattern defers instantiation of a class to its subclasses.

## Example

> The coin factory can manufacture various types of coins, such as five-dollar coins and ten-dollar coins, and must be able to switch between them without modifying existing source code.

## Programmatic Example

Create an interface for coins and implement different types of coins.

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

Defines the types of coins that can be created.

```java
public enum CoinType {
    TEN, FIVE;
}
```

Design a factory to create coin objects encapsulated in a factory class.

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

Program execution：

```java
CoinFactory cf = new CoinFactory();
Coin coinTen = cf.getCoin(CoinType.TEN);
Coin coinFive = cf.getCoin(CoinType.FIVE);
coinTen.getDescription();
coinFive.getDescription();
```

Program output：

```java
This is a ten dollar coin.
This is a five dollar coin.
```
