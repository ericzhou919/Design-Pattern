package design_pattern.design_pattern.Behavioral.Command;

import java.util.ArrayList;
import java.util.List;

public class Broker {
   private List<Order> orderList = new ArrayList<Order>();

   public void takeOrder(Order order) {
      orderList.add(order);
   }

   public void placeOrders() {
      System.out.println("placeOrders");
      for (Order order : orderList) {
         order.execute();
      }
      orderList.clear();
   }
}
