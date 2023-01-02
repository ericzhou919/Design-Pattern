package design_pattern.design_pattern.Behavioral.ChainOfResponsibility;

class PlatoonLeader extends Sir {
   // 排長
   public PlatoonLeader() {
      super("PlatoonLeader");
   }

   public void handleRequest(int requestLevel) {
      if (requestLevel <= 2) {
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