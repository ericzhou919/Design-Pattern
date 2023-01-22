package design_pattern.design_pattern.Concurrency.DoubleCheckedLocking;

public class DoubleCheckedLocking 
{
    public static void UseDoubleCheckedLocking() throws InterruptedException
    {
        DoubleCheckedLockingSingleton singleton1 = DoubleCheckedLockingSingleton.getInstance();
        DoubleCheckedLockingSingleton singleton2 = DoubleCheckedLockingSingleton.getInstance();
        System.out.println(singleton1 == singleton2); 
    }

}
