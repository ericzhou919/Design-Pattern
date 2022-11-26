package design_pattern.design_pattern.Behavioral.TemplateMethod;

public class TemplateMethod 
{
    public static void UseTemplateMethod()
    {
        HouseTemplate houseType = new WoodenHouse();
        houseType.buildHouse();

        System.out.println("");

        houseType = new GlassHouse();
        houseType.buildHouse();
    }

}
