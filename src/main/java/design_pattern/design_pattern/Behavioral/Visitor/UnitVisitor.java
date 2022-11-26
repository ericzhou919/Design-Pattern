package design_pattern.design_pattern.Behavioral.Visitor;



public interface UnitVisitor {

    void visit(Soldier soldier);

    void visit(Sergeant sergeant);

    void visit(Commander commander);
}