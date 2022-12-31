package design_pattern.design_pattern.Creational.Factory;

public class Factory {
    public static void UseFactory() {
        CoinFactory cf = new CoinFactory();
        Coin coinTen = cf.getCoin(CoinType.TEN);
        Coin coinFive = cf.getCoin(CoinType.FIVE);
        coinTen.getDescription();
        coinFive.getDescription();
    }

}
