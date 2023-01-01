## 定義

將複雜對象的「構造」與「表示」分開，以便相同的構造過程可以創建不同的表示。

## 例子   

> 遊戲玩家創建角色時，選擇角色的姓名、職業、性別、外貌等，角色生成將成為一個循序漸進的過程，當所有選擇都準備時完成。  
  
## 程式碼範例  
建立角色屬性。
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
    return "PlayerCharacter [haircolor=" + haircolor + ", name=" + name + ", profession=" + profession + ", sex=" + sex
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

建立Builder。  
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

程式執行：  
```java
PlayerCharacter pc = new PlayerCharacter.Builder(Profession.WARRIOR, "Test").setHairColor(HairColor.BLACK).setSex(Sex.MALE).build();
System.out.println("This your character: " + pc.toString());
```  

輸出：  
```java
This your character: PlayerCharacter [haircolor=black, name=Test, profession=warrior, sex=male]
```
