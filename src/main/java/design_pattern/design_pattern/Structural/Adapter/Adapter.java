package design_pattern.design_pattern.Structural.Adapter;

public class Adapter 
{
    public static void UseAdapter()
    {
        Sparrow sparrow = new Sparrow();
        System.out.println("Sparrow:");
        sparrow.fly();
        sparrow.makeSound();
        System.out.println("");

        ToyDuck toyDuck = new PlasticToyDuck();
        System.out.println("ToyDuck:");
        toyDuck.squeak();
        System.out.println("");

        ToyDuck birdAdapter = new BirdAdapter(sparrow);
        System.out.println("BirdAdapter:");
        birdAdapter.squeak();
    }

}
