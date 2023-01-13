package design_pattern.design_pattern.Structural.Bridge;

public class Bridge {
    public static void UseBridge() {
        Sword fireSword = new Sword(new FireEnchantment());
        fireSword.attack();
        fireSword.releaseEnchantment();

        System.out.println();

        Knife iceKnife = new Knife(new IceEnchantment());
        iceKnife.attack();
        iceKnife.releaseEnchantment();
    }
}
