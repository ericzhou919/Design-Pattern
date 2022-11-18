package design_pattern.design_pattern.Creational.Singleton;

/**
 * Hello world!
 *
 */
public class Singleton {
    public static void UseSingleton() {
        System.out.println("UseSingleton");
        SingletonObject s1 = SingletonObject.getInstance();
        SingletonObject s2 = SingletonObject.getInstance();
        System.out.println("s1:" + s1.hashCode());
        System.out.println("s2:" + s2.hashCode());
    }

}
