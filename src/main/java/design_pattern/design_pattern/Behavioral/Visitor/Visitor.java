package design_pattern.design_pattern.Behavioral.Visitor;

public class Visitor 
{
    public static void UseVisitor()
    {
        Commander commander = new Commander(
                new Sergeant(new Soldier(), new Soldier(), new Soldier()),
                new Sergeant(new Soldier(), new Soldier(), new Soldier()));

        commander.accept(new SoldierVisitor());
        System.out.println("");

        commander.accept(new SergeantVisitor());
        System.out.println("");
        
        commander.accept(new CommanderVisitor());
    }

}
