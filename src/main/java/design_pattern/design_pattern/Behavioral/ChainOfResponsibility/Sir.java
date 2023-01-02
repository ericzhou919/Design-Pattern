package design_pattern.design_pattern.Behavioral.ChainOfResponsibility;

abstract class Sir {
   private Sir next;
   private String name;

   public Sir(String name) {
      this.name = name;
   }

   public void setNext(Sir next) {
      this.next = next;
   }

   public Sir getNext() {
      return next;
   }

   public void requestSuccesses(int LeaveDays) {
      System.out.println(this.name + " approve your level " + LeaveDays + " request.");
   }

   public void requestFailed() {
      System.out.println("No one has the right to approve.");
   }
   
   public abstract void handleRequest(int LeaveDays);
}
