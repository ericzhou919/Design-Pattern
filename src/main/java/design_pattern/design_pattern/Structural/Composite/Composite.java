package design_pattern.design_pattern.Structural.Composite;

public class Composite {
    public static void UseComposite() {
        Employee CEO = new Employee("BOSS", "CEO", 30000);

        Employee headSales = new Employee("Head S", "Head Sales", 20000);

        Employee headMarketing = new Employee("Head M", "Head Marketing", 20000);

        Employee clerk1 = new Employee("M1", "Marketing", 10000);
        Employee clerk2 = new Employee("M2", "Marketing", 10000);

        Employee sales1 = new Employee("S1", "Sales", 10000);
        Employee sales2 = new Employee("S2", "Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(sales1);
        headSales.add(sales2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        System.out.println(CEO);
        CEO.traversel(CEO);
    }
}
