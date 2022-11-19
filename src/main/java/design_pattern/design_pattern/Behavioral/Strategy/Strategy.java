package design_pattern.design_pattern.Behavioral.Strategy;


public class Strategy 
{
    public static void UseStrategy()
    {
        Adventurer ad = new Adventurer();

        System.out.println("Encounter normal monster");
        ad.choiceStrategy(new NormalAttack());
        ad.attack();

        System.out.println("Encounter giant monster");
        ad.choiceStrategy(new SkillAttack());
        ad.attack();

        System.out.println("Encounter special monster");
        ad.choiceStrategy(new ItemAttack());
    }

}
