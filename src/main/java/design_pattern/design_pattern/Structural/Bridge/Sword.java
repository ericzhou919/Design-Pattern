package design_pattern.design_pattern.Structural.Bridge;

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
