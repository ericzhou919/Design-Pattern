package design_pattern.design_pattern.Behavioral.Visitor;

public class CommanderVisitor implements UnitVisitor {

    @Override
    public void visit(Soldier soldier) {
        // Do nothing
    }
    @Override
    public void visit(Sergeant sergeant) {
        // Do nothing
    }
    @Override
    public void visit(Commander commander) {
        System.out.println("Hello " + commander);
    }
}