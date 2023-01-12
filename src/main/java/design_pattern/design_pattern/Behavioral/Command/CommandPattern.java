package design_pattern.design_pattern.Behavioral.Command;

public class CommandPattern {
   public static void UseCommand() {
      IPhone i = new IPhone();
      Invoker invoker = new Invoker();

      invoker.addCommand(new TurnOn(i));
      invoker.addCommand(new IncreaseVolume(i));
      invoker.addCommand(new DecreaseVolume(i));
      invoker.addCommand(new TurnOff(i));

      invoker.execute();
   }
}
