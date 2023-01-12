package design_pattern.design_pattern.Behavioral.Command;

public class IncreaseVolume extends Command {
   public IncreaseVolume(IPhone iphone) {
      super(iphone);
   }

   @Override
   public void execute() {
      iphone.increaseVolume();
   }
}
