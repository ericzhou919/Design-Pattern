[English](README.md) ∙ [繁體中文](README-zh-TW.md)  

## Definition

Separate the construction of a complex object from its representation so that the same construction process can create different representations.  

## Example   

> When game players create a character, selecting the character's name, class, gender, appearance, etc., character generation will be a gradual process that is completed when all choices are ready.
  
## Programmatic Example
Create Character.
```java
public final class Character {
  private  Profession profession;
  private  String name;
  private  HairColor hairColor;
  private  Sex sex;

  private Character(Builder builder) {
    this.profession = builder.profession;
    this.name = builder.name;
    this.hairColor = builder.haircolor;
    this.sex = builder.sex;
  }
  @Override
  public String toString() {
    return "[haircolor=" + haircolor + ", name=" + name + ", profession=" + profession + ", sex=" + sex
        + "]";
  }
}

public enum Profession {
  WARRIOR, TANK, ARCHER, PRIEST;
  @Override
  public String toString() {
    return name().toLowerCase();
  }
}

public enum HairColor {
  RED, BLUE, BLACK;
  @Override
  public String toString() {
    return name().toLowerCase();
  }
}

public enum Sex {
  MALE, FEMALE;
  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
```  

Create Builder.  
```java
public static class Builder {

    private final Profession profession;
    private final String name;
    private HairColor haircolor;
    private Sex sex;

    public Builder(Profession profession, String name) {
      if (profession == null || name == null) {
        throw new IllegalArgumentException("profession and name can not be null");
      }
      this.profession = profession;
      this.name = name;
    }

    public Builder setHairColor(HairColor hairColor) {
      this.haircolor = hairColor;
      return this;
    }

    public Builder setSex(Sex sex) {
      this.sex = sex;
      return this;
    }

    public PlayerCharacter build() {
      return new PlayerCharacter(this);
    }

}

```    

Program execution：
```java
PlayerCharacter pc = new PlayerCharacter.Builder(Profession.WARRIOR, "Test").setHairColor(HairColor.BLACK).setSex(Sex.MALE).build();
System.out.println("This your character: " + pc.toString());
```  

Program output：  
```java
This your character: [haircolor=black, name=Test, profession=warrior, sex=male]
```
