package design_pattern.design_pattern.Creational.Builder;

public final class PlayerCharacter {
  private  Profession profession;
  private  String name;
  private  HairColor haircolor;
  private  Sex sex;

  private PlayerCharacter(Builder builder) {
    this.profession = builder.profession;
    this.name = builder.name;
    this.haircolor = builder.haircolor;
    this.sex = builder.sex;
  }
  public Profession getProfession() {
    return profession;
  }
  public String getName() {
    return name;
  }
  public HairColor getHaircolor() {
    return haircolor;
  }
  public Sex getSex() {
    return sex;
  }
  @Override
  public String toString() {
    return "PlayerCharacter [haircolor=" + haircolor + ", name=" + name + ", profession=" + profession + ", sex=" + sex
        + "]";
  }
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
  
}