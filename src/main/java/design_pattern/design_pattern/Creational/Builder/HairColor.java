package design_pattern.design_pattern.Creational.Builder;

public enum HairColor {

  RED, BLUE, BLACK;

  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
