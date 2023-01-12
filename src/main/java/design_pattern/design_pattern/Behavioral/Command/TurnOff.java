package design_pattern.design_pattern.Behavioral.Command;

public class TurnOff extends Command {
   public TurnOff(IPhone iphone) {
      super(iphone);
   }

   @Override
   public void execute() {
      iphone.turnOff();
   }
}