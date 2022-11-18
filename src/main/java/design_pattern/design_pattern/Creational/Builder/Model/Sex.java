package design_pattern.design_pattern.Creational.Builder.Model;

public enum Sex {

  MALE, FEMALE;

  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
