package design_pattern.design_pattern.Structural.Decorator;

public class Decorator {
    public static void UseDecorator() {
        Man m = new Man();
        m.startEating();
        System.out.println("A man is eating without utensils.");

        PeopleWithChopsticks pwcm = new PeopleWithChopsticks(m);
        pwcm.startEating();

        PeopleWithFork pwfm = new PeopleWithFork(m);
        pwfm.startEating();

        System.out.println("");

        Woman w = new Woman();
        w.startEating();
        System.out.println("A woman is eating without utensils.");

        PeopleWithChopsticks pwcw = new PeopleWithChopsticks(w);
        pwcw.startEating();

        PeopleWithFork pwfw = new PeopleWithFork(w);
        pwfw.startEating();
    }
}
