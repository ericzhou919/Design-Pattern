package design_pattern.design_pattern.Structural.Proxy;

public class Proxy 
{
    public static void UseProxy()
    {
        Internet internet = new ProxyInternet();
        try {
            internet.connectTo("test.com");
            internet.connectTo("abc.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
