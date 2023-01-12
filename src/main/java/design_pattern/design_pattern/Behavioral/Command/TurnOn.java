package design_pattern.design_pattern.Behavioral.Command;

public class TurnOn extends Command {
   public TurnOn(IPhone iphone) {
      super(iphone);
   }

   @Override
   public void execute() {
      iphone.turnOn();
   }
}