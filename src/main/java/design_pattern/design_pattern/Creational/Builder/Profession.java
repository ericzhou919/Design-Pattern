package design_pattern.design_pattern.Creational.Builder;

public enum Profession {

  WARRIOR, TANK, ARCHER, PRIEST;

  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
