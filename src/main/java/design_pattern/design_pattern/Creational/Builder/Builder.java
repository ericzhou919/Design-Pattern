package design_pattern.design_pattern.Creational.Builder;

public class Builder
{
    public static void UseBuilder()
    {
        System.out.println("UseBuilder");
        PlayerCharacter pc = new PlayerCharacter.Builder(Profession.WARRIOR, "Test").setHairColor(HairColor.BLACK).setSex(Sex.MALE).build();
        System.out.println("This your character: "+pc.toString());
    }

}
