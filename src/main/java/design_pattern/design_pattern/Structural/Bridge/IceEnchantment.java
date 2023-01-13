package design_pattern.design_pattern.Structural.Bridge;

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