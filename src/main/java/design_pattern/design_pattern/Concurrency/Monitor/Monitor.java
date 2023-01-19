package design_pattern.design_pattern.Concurrency.Monitor;

public class Monitor 
{
    public static void UseMonitor()
    {
        VisitableHouse house = new VisitableHouse();
        Thread visitor1 = new Thread(new Visitor(house, "visitor#1"));
        Thread visitor2 = new Thread(new Visitor(house, "visitor#2"));
        Thread visitor3 = new Thread(new Visitor(house, "visitor#3"));
        Thread visitor4 = new Thread(new Visitor(house, "visitor#4"));
        Thread visitor5 = new Thread(new Visitor(house, "visitor#5"));
        visitor1.start();
        visitor2.start();
        visitor3.start();
        visitor4.start();
        visitor5.start();
    }

}
