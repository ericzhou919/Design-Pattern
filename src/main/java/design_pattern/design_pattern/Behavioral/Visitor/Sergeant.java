package design_pattern.design_pattern.Behavioral.Visitor;


public class Sergeant extends Unit {
    public Sergeant(Unit... children) {
        super(children);
    }
    @Override
    public void accept(UnitVisitor visitor) {
        visitor.visit(this);
        super.accept(visitor);
    }

    @Override
    public String toString() {
        return "sergeant";
    }
}