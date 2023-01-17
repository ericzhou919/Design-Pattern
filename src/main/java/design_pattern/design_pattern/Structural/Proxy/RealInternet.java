package design_pattern.design_pattern.Structural.Proxy;

public class RealInternet implements Internet {
    @Override
    public void connectTo(String host) {
        System.out.println("Connecting to " + host);
    }
}
