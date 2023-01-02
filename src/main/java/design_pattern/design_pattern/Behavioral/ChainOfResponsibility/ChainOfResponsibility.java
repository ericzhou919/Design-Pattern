package design_pattern.design_pattern.Behavioral.ChainOfResponsibility;

public class ChainOfResponsibility {

   public static void UseChainOfResponsibility() {
      Sir SquadLeader = new SquadLeader();
      Sir PlatoonLeader = new PlatoonLeader();
      Sir CompanyLeader = new CompanyLeader();
      SquadLeader.setNext(PlatoonLeader);
      PlatoonLeader.setNext(CompanyLeader);

      //放入不同等級的Request
      SquadLeader.handleRequest(1);
      SquadLeader.handleRequest(2);
      SquadLeader.handleRequest(3);
      SquadLeader.handleRequest(4);
   }
}
