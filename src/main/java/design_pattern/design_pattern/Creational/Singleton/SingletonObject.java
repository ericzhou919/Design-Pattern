package design_pattern.design_pattern.Creational.Singleton;

public class SingletonObject 
{
    private static SingletonObject instance;

    private SingletonObject() {}

    public static SingletonObject getInstance() {
        if (instance == null) {
            instance = new SingletonObject();
        }
        return instance;
    }
}
