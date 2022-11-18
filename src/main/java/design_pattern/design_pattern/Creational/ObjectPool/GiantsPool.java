package design_pattern.design_pattern.Creational.ObjectPool;

public class GiantsPool extends ObjectPool<Giants> {

    @Override
    protected Giants create() {
        return new Giants();
    }
}