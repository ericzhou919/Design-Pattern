package design_pattern.design_pattern.Structural.Bridge;

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
