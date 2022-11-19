package design_pattern.design_pattern.Behavioral.Strategy;


public class ItemAttack implements FightStrategy {
    @Override
    public void execute() {
        System.out.println("Use ItemAttack");
    }
}
