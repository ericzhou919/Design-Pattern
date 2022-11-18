package design_pattern.design_pattern.Creational.AbstractFactory;

public class AbstractFactory 
{
    public interface Noodles {
        void getDescription();
    }
    
    public interface Rice {
        void getDescription();
    }
    public interface FoodFactory {
        Noodles createNoodles();
        Rice createRice();
    }
    public class CurryNoodles implements Noodles {
        @Override
        public void getDescription() {
            System.out.println("This is the Curry Noodles!");
        }
    }
    public class CurryRice implements Rice {
        @Override
        public void getDescription() {
            System.out.println("This is the Curry Rice!");
        }
    }
    public class CurryFoodFactory implements FoodFactory {

        @Override
        public Noodles createNoodles() {
          return new CurryNoodles();
        }
      
        @Override
        public Rice createRice() {
          return new CurryRice();
        }
      }
    public static void UseAbstractFactory()
    {
        System.out.println("UseAbstractFactory");
        AbstractFactory a = new AbstractFactory();
        CurryFoodFactory factory = a.new CurryFoodFactory();
        CurryNoodles cn=(CurryNoodles) factory.createNoodles();
        CurryRice cr=(CurryRice) factory.createRice();
        cn.getDescription();
        cr.getDescription();
    }

}
