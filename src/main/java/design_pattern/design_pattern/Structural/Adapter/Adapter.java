package design_pattern.design_pattern.Structural.Adapter;

public class Adapter 
{
    public static void UseAdapter()
    {
        System.out.println("UseAdapter");
        Shape square = new Square();
        System.out.println("CurrentShape Square Area " + square.calculateArea(5));
        Shape circle = new CircleAdaptor();
        System.out.println("NewShape Circle Area " + circle.calculateArea(5));
    }

}
