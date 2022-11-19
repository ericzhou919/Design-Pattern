package design_pattern.design_pattern.Behavioral.Strategy;


public class SkillAttack implements FightStrategy {
    @Override
    public void execute() {
        System.out.println("Use SkillAttack");
    }
}
