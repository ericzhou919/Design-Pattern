package design_pattern.design_pattern.Creational.Factory;

import java.util.function.Supplier;

/**
 * Hello world!
 *
 */
public class Factory 
{
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
    
    public static void UseFactory()
    {
        System.out.println("UseFactory");
    }

}
