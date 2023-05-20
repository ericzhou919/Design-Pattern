## Definition

Separate the abstraction from the implementation so that both can vary independently.  

## Example

>In a game, the Bridge Pattern can be used to create separate enchantments and attach them to different weapons as needed.  

## Programmatic Example

Create the Weapon and Enchantment interface.  

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

Implement weapons, knives and swords.  

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

Enchanting implementation, fire enchantment, and frost enchantment.  

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

Program execution：

```java
Sword fireSword = new Sword(new FireEnchantment());
fireSword.attack();
fireSword.releaseEnchantment();

System.out.println();

Knife iceKnife = new Knife(new IceEnchantment());
iceKnife.attack();
iceKnife.releaseEnchantment();
```

Program output：

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
