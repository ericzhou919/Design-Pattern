package design_pattern.design_pattern.Behavioral.ChainOfResponsibility;

public class ErrorLogger extends AbstractLogger {

   public ErrorLogger(int level){
      this.level = level;
   }

   @Override
   protected void write(String message) {		
      System.out.println("Error Console Logger: " + message);
   }
}