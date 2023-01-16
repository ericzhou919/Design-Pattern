package design_pattern.design_pattern.Structural.Adapter;

public class Sparrow implements Bird {
    public void fly() {
        System.out.println("Flying");
    }

    public void makeSound() {
        System.out.println("Chirp Chirp");
    }
}