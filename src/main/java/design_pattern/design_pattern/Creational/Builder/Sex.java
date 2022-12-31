package design_pattern.design_pattern.Creational.Builder;

public enum Sex {

  MALE, FEMALE;

  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
