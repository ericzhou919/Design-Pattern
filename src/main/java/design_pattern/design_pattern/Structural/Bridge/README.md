## 定義

將抽象部分與實現部分分離，以便兩者可以獨立的變化。

## 例子   

> 遊戲裡，不同的武器配合不同的附魔，Bridge Pattern可以創建單獨的附魔並根據需求附在不同的武器上。  
  
## 程式碼範例  
建立Weapon和Enchantment介面。
```java
public interface Weapon {

  void attack();

  void releaseEnchantment();

  Enchantment getEnchantment();
}

public interface Enchantment {

  void enchantmentAttack();

  void onDeactivate();
}
```   

實作武器，刀和劍。
```java
public class Knife implements Weapon {

  private final Enchantment enchantment;

  public Knife(Enchantment enchantment) {
    this.enchantment = enchantment;
  }

  @Override
  public void attack() {
    System.out.println("Knife attack");
    enchantment.enchantmentAttack();
  }

  @Override
  public void releaseEnchantment() {
    System.out.println("Knife release");
    enchantment.onDeactivate();
  }

  @Override
  public Enchantment getEnchantment() {
    return enchantment;
  }

}

public class Sword implements Weapon {

  private final Enchantment enchantment;

  public Sword(Enchantment enchantment) {
    this.enchantment = enchantment;
  }

  @Override
  public void attack() {
    System.out.println("Sword attack");
    enchantment.enchantmentAttack();
  }

  @Override
  public void releaseEnchantment() {
    System.out.println("Sword release");
    enchantment.onDeactivate();
  }

  @Override
  public Enchantment getEnchantment() {
    return enchantment;
  }
}
```   

實作附魔，火焰附魔和冰凍附魔。
```java
public class FireEnchantment implements Enchantment {

  public FireEnchantment() {
    System.out.println("The weapon get fire enchantment.");
  }

  @Override
  public void enchantmentAttack() {
    System.out.println("The fire weapon attack.");
  }

  @Override
  public void onDeactivate() {
    System.out.println("The weapon lost fire enchantment.");
  }

}

public class IceEnchantment implements Enchantment {

  public IceEnchantment() {
    System.out.println("The weapon get ice enchantment.");
  }

  @Override
  public void enchantmentAttack() {
    System.out.println("The ice weapon attack.");
  }

  @Override
  public void onDeactivate() {
    System.out.println("The weapon lost ice enchantment.");
  }

}
```   

程式執行：  
```java
Sword fireSword = new Sword(new FireEnchantment());
fireSword.attack();
fireSword.releaseEnchantment();

System.out.println();

Knife iceKnife = new Knife(new IceEnchantment());
iceKnife.attack();
iceKnife.releaseEnchantment();
```  

輸出：  
```java
The weapon get fire enchantment.
Sword attack
The fire weapon attack.
Sword release
The weapon lost fire enchantment.

The weapon get ice enchantment.
Knife attack
The ice weapon attack.
Knife release
The weapon lost ice enchantment.
```
