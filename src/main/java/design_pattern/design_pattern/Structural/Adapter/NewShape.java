package design_pattern.design_pattern.Structural.Adapter;

class Circle {
    public double calculateCircularArea(int r) {
        return 3.14 * r * r;
    }
}

class CircleAdaptor extends Circle implements Shape {
    @Override
    public int calculateArea(int r) {
        return (int) calculateCircularArea(r);
    }
}