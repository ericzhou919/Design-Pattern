package design_pattern.design_pattern.Behavioral.Command;

public class SellStock implements Order {
   private Stock stock;

   public SellStock(Stock stock) {
      this.stock = stock;
   }

   public void execute() {
      stock.sell();
   }
}
