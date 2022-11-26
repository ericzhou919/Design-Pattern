package design_pattern.design_pattern.Behavioral.Visitor;


public class SoldierVisitor implements UnitVisitor {

    @Override
    public void visit(Soldier soldier) {
       System.out.println("Hello "+ soldier);
    }
    @Override
    public void visit(Sergeant sergeant) {
        // Do nothing
    }

    @Override
    public void visit(Commander commander) {
        // Do nothing
    }
}