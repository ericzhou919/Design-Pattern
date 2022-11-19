package design_pattern.design_pattern.Behavioral.NullObject;

public class NullObject 
{
    public static void UseNullObject()
    {
        AbstractCustomer customer1 = CustomerFactory.getCustomer("A");
        AbstractCustomer customer2 = CustomerFactory.getCustomer("D");
        AbstractCustomer customer3 = CustomerFactory.getCustomer("B");
        AbstractCustomer customer4 = CustomerFactory.getCustomer("E");

        System.out.println("UseNullObject");
        System.out.println(customer1.getName());
        System.out.println(customer2.getName());
        System.out.println(customer3.getName());
        System.out.println(customer4.getName());
    }

}
