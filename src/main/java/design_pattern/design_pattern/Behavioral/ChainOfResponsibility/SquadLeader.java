package design_pattern.design_pattern.Behavioral.ChainOfResponsibility;

class SquadLeader extends Sir {
   // 班長
   public SquadLeader() {
      super("SquadLeader");
   }

   public void handleRequest(int requestLevel) {
      if (requestLevel <= 1) {
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