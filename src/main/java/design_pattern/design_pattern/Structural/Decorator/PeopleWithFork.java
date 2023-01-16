package design_pattern.design_pattern.Structural.Decorator;

public class PeopleWithFork implements People {

    private final People decorated;

    public PeopleWithFork(People decorated) {
        this.decorated = decorated;
    }

    @Override
    public void startEating() {
        System.out.println("");
        decorated.startEating();
        System.out.println("Eating With Fork.");
    }
}
