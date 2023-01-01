package design_pattern.design_pattern.Creational.Multiton;

public class Multiton 
{
    public static void UseMultiton()
    {
        System.out.println("OneTail= " + TailedBeast.getInstance(TailedBeastName.Shukaku));
        System.out.println("TwoTail= " + TailedBeast.getInstance(TailedBeastName.Matatabi));
        System.out.println("ThreeTail= " + TailedBeast.getInstance(TailedBeastName.Isobu));
        System.out.println("FourTail= " + TailedBeast.getInstance(TailedBeastName.SonGokū));
        System.out.println("FiveTail= " + TailedBeast.getInstance(TailedBeastName.Kokuō));
        System.out.println("SixTail= " + TailedBeast.getInstance(TailedBeastName.Saiken));
        System.out.println("SevenTail= " +TailedBeast.getInstance(TailedBeastName.Chōmei));
        System.out.println("EightTail= " + TailedBeast.getInstance(TailedBeastName.UshiOni));
        System.out.println("NineTail= " + TailedBeast.getInstance(TailedBeastName.Kurama));
        
        System.out.println("OneTail= " + TailedBeastEnum.Shukaku);
        System.out.println("TwoTail= " + TailedBeastEnum.Matatabi);
        System.out.println("ThreeTail= " + TailedBeastEnum.Isobu);
        System.out.println("FourTail= " + TailedBeastEnum.SonGokū);
        System.out.println("FiveTail= " + TailedBeastEnum.Kokuō);
        System.out.println("SixTail= " + TailedBeastEnum.Saiken);
        System.out.println("SevenTail= " + TailedBeastEnum.Chōmei);
        System.out.println("EightTail= " + TailedBeastEnum.UshiOni);
        System.out.println("NineTail= " + TailedBeastEnum.Kurama);
    }

}
