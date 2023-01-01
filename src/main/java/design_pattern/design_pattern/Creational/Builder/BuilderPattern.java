package design_pattern.design_pattern.Creational.Builder;

public class BuilderPattern
{
    public static void UseBuilder() {
        PlayerCharacter pc = new PlayerCharacter.Builder(Profession.WARRIOR, "Test").setHairColor(HairColor.BLACK)
                .setSex(Sex.MALE).build();
        System.out.println("This your character: " + pc.toString());
    }

}
