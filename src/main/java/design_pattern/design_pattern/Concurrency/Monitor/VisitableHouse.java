package design_pattern.design_pattern.Concurrency.Monitor;

public class VisitableHouse {

  private Object visit = new Object();

  public void visit(String visitor) {
    System.out.println(visitor+" is waiting for the visit");
    synchronized(visit) {
      try {
        Thread.sleep(1000);
        System.out.println(visitor+" is visited the house");
      } catch (Exception e) {
        e.printStackTrace();
      }
    };
  }
}