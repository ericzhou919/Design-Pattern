package design_pattern.design_pattern.Concurrency.Monitor;

public class Visitor implements Runnable {
  private VisitableHouse house;
  private String name;

  public Visitor(VisitableHouse house, String name) {
    this.house = house;
    this.name = name;
  }

  @Override
  public void run() {
    this.house.visit(this.name);
  }
}