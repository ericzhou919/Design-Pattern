package design_pattern.design_pattern.Behavioral.Command;

public class DecreaseVolume extends Command {
   public DecreaseVolume(IPhone iphone) {
      super(iphone);
   }

   @Override
   public void execute() {
      iphone.decreaseVolume();
   }
}