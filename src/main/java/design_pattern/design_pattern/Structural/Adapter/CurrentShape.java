package design_pattern.design_pattern.Structural.Adapter;

interface Shape {
    public int calculateArea(int r);
}

class Square implements Shape {
    @Override
    public int calculateArea(int r) {
        return r * r;
    }
}
