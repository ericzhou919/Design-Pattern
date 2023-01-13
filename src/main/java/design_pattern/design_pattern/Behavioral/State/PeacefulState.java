package design_pattern.design_pattern.Behavioral.State;

public class PeacefulState implements State {

  private final Mammoth mammoth;

  public PeacefulState(Mammoth mammoth) {
    this.mammoth = mammoth;
  }

  @Override
  public void observe() {
    System.out.println(mammoth + " is calm and peaceful.");
  }

  @Override
  public void onEnterState() {
    System.out.println(mammoth + " calms down.");
  }
}
