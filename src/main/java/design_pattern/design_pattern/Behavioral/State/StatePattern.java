package design_pattern.design_pattern.Behavioral.State;

public class StatePattern {

  public static void UseState() {
    Mammoth mammoth = new Mammoth();
    mammoth.observe();
    mammoth.timePasses();
    mammoth.observe();
    mammoth.timePasses();
    mammoth.observe();
  }

}