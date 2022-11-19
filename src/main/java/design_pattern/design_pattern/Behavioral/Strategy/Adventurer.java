package design_pattern.design_pattern.Behavioral.Strategy;


public class Adventurer {
    FightStrategy fightStrategy;

    public void attack() {
        if (fightStrategy == null) {
            fightStrategy = new NormalAttack();
        }
        fightStrategy.execute();
    }

    public void choiceStrategy(FightStrategy strategy) {
        this.fightStrategy = strategy;
    }
}
