package design_pattern.design_pattern.Structural.Bridge;

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