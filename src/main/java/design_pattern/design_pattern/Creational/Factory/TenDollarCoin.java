package design_pattern.design_pattern.Creational.Factory;

public class TenDollarCoin implements Coin {
    @Override
    public void getDescription() {
        System.out.println("This is a ten dollar coin.");
    }
}