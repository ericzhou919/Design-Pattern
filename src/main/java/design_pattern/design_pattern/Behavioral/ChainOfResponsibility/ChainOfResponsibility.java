package design_pattern.design_pattern.Behavioral.ChainOfResponsibility;

public class ChainOfResponsibility {
	
   private static AbstractLogger getChainOfLoggers(){

      AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
      AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
      AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

      errorLogger.setNextLogger(fileLogger);
      fileLogger.setNextLogger(consoleLogger);

      return errorLogger;	
   }

   public static void UseChainOfResponsibility() {
      AbstractLogger loggerChain = getChainOfLoggers();

      loggerChain.logMessage(AbstractLogger.INFO, 
            "This is an information.");
         
      System.out.println("");

      loggerChain.logMessage(AbstractLogger.DEBUG, 
         "This is an debug level information.");

      System.out.println("");
         
      loggerChain.logMessage(AbstractLogger.ERROR, 
         "This is an error information.");
   }
}
