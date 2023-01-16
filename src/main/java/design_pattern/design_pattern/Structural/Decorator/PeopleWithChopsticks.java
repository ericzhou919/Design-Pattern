package design_pattern.design_pattern.Structural.Decorator;

public class PeopleWithChopsticks implements People {

    private final People decorated;

    public PeopleWithChopsticks(People decorated) {
        this.decorated = decorated;
    }

    @Override
    public void startEating() {
        System.out.println("");
        decorated.startEating();
        System.out.println("Eating With Chopsticks.");
    }
}