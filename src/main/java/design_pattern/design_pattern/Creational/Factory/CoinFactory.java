package design_pattern.design_pattern.Creational.Factory;

public class CoinFactory {
    public Coin getCoin(CoinType _coinType) {
        if (_coinType.equals(CoinType.TEN)) {
            return new TenDollarCoin();
        } else if (_coinType.equals(CoinType.FIVE)) {
            return new FiveDollarCoin();
        }
        return null;
    }
}
