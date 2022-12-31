package design_pattern.design_pattern.Creational.Factory;

public class FiveDollarCoin implements Coin {
    @Override
    public void getDescription() {
        System.out.println("This is a five dollar coin.");
    }
}