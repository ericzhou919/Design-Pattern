package design_pattern.design_pattern.Behavioral.Visitor;

public class SergeantVisitor implements UnitVisitor {

    @Override
    public void visit(Soldier soldier) {
        // Do nothing
    }

    @Override
    public void visit(Sergeant sergeant) {
        System.out.println("Hello " + sergeant);
    }

    @Override
    public void visit(Commander commander) {
        // Do nothing
    }
}