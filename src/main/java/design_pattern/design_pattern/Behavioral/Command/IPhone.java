package design_pattern.design_pattern.Behavioral.Command;

public class IPhone {
   public void turnOn() {
      System.out.println("IPhone is on");
   }

   public void turnOff() {
      System.out.println("IPhone is off");
   }

   public void increaseVolume() {
      System.out.println("The volume has been increased");
   }

   public void decreaseVolume() {
      System.out.println("The volume has been decreased");
   }
}
