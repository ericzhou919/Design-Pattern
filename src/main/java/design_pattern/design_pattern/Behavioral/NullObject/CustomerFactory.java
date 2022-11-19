package design_pattern.design_pattern.Behavioral.NullObject;

public class CustomerFactory {

    public static final String[] names = { "A", "B", "C" };

    public static AbstractCustomer getCustomer(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}