package design_pattern.design_pattern.Creational.Factory;

public class Factory {
    public interface Coin {
        void getDescription();
    }

    public class TenDollarCoin implements Coin {
        @Override
        public void getDescription() {
            System.out.println("This is a ten dollar coin.");
        }
    }

    public class FiveDollarCoin implements Coin {
        @Override
        public void getDescription() {
            System.out.println("This is a five dollar coin.");
        }
    }

    public enum CoinType {
        TEN, FIVE;
    }

    class CoinFactory {
        public Coin makeCoin(CoinType _coinType) {
            if (_coinType.equals(CoinType.TEN)) {
                return new TenDollarCoin();
            } else if (_coinType.equals(CoinType.FIVE)) {
                return new FiveDollarCoin();
            }
            return null;
        }
    }

    public static void UseFactory() {
        System.out.println("UseFactory");
        Factory f = new Factory();
        CoinFactory cf = f.new CoinFactory();
        Coin c_ten = cf.makeCoin(CoinType.TEN);
        Coin c_five = cf.makeCoin(CoinType.FIVE);
        c_ten.getDescription();
        c_five.getDescription();
    }

}
