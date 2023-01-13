package design_pattern.design_pattern.Behavioral.State;

public class AngryState implements State {

  private final Mammoth mammoth;

  public AngryState(Mammoth mammoth) {
    this.mammoth = mammoth;
  }

  @Override
  public void observe() {
    System.out.println(mammoth + " is furious!");
  }

  @Override
  public void onEnterState() {
    System.out.println(mammoth + " gets angry!");
  }
}
