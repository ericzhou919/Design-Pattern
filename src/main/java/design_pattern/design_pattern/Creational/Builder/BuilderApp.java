package design_pattern.design_pattern.Creational.Builder;

import design_pattern.design_pattern.Creational.Builder.Model.HairColor;
import design_pattern.design_pattern.Creational.Builder.Model.PlayerCharacter;
import design_pattern.design_pattern.Creational.Builder.Model.Profession;
import design_pattern.design_pattern.Creational.Builder.Model.Sex;

/**
 * Hello world!
 *
 */
public class BuilderApp 
{
    public static void UseBuilder()
    {
        System.out.println("UseBuilder");
        PlayerCharacter pc = new PlayerCharacter.Builder(Profession.WARRIOR, "Test").setHairColor(HairColor.BLACK).setSex(Sex.MALE).build();
        System.out.println("This your character: "+pc.toString());
    }

}
