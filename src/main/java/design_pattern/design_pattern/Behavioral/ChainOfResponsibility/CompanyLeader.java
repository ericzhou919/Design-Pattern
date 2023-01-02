package design_pattern.design_pattern.Behavioral.ChainOfResponsibility;

class CompanyLeader extends Sir {
   // 連長
   public CompanyLeader() {
      super("CompanyLeader");
   }

   public void handleRequest(int requestLevel) {
      if (requestLevel <= 3) {
         this.requestSuccesses(requestLevel);
      } else {
         if (getNext() != null) {
            getNext().handleRequest(requestLevel);
         } else {
            this.requestFailed();
         }
      }
   }
}