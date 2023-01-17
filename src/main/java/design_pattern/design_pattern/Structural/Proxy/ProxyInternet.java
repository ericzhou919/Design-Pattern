package design_pattern.design_pattern.Structural.Proxy;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet {
    private Internet internet = new RealInternet();
    private static List<String> bannedSites;

    static {
        bannedSites = new ArrayList<String>();
        bannedSites.add("abc.com");
        bannedSites.add("def.com");
        bannedSites.add("ijk.com");
        bannedSites.add("lnm.com");
    }

    @Override
    public void connectTo(String host) throws Exception {
        if (bannedSites.contains(host.toLowerCase())) {
            throw new Exception("Access Denied");
        }

        internet.connectTo(host);
    }

}
