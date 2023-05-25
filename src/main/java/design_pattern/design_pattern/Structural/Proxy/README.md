## Definition

To provide a proxy for another object to control access to it.  

## Proxy type

- Remote Proxy: Enables an object located at a different address to provide a local representative object. For instance, it allows services in the United States to be incorporated as part of services in Taiwan through the proxy pattern.
- Virtual Proxy: Defers the creation of a resource-intensive or complex object until it is actually needed. For instance, when loading images, if the image file is excessively large, a proxy with a smaller thumbnail image is used as a substitute. Once the actual image is loaded, it is displayed to the client.
- Protection Proxy: Controls access permissions to the original object.
- Smart Proxy: Used to invoke the target object while adding additional functionality, such as recording access logs or traffic.  
- Caching Proxy: Stores the computed results of an object in a temporary shared space, allowing different clients to retrieve these shared results.

## Example

> This example demonstrates a Protection Proxy where the proxy first checks the host you want to connect to. If it is not part of the restricted website list, it will connect to the actual network.  

## Programmatic Example

Create Internet interface and implement RealInternet.  

```java
public interface Internet {
    public void connectTo(String host) throws Exception;
}

public class RealInternet implements Internet {
    @Override
    public void connectTo(String host) {
        System.out.println("Connecting to " + host);
    }
}
```

Create ProxyInternet。

```java
public class ProxyInternet implements Internet {
    private Internet internet = new RealInternet();
    private static List<String> bannedSites;

    static {
        bannedSites = new ArrayList<String>();
        bannedSites.add("abc.com");
    }

    @Override
    public void connectTo(String host) throws Exception {
        if (bannedSites.contains(host.toLowerCase())) {
            throw new Exception("Access Denied");
        }

        internet.connectTo(host);
    }
}
```

Program execution：

```java
Internet internet = new ProxyInternet();
try {
    internet.connectTo("test.com");
    internet.connectTo("abc.com");
} catch (Exception e) {
    System.out.println(e.getMessage());
}
```

Program output：

```java
Connecting to test.com
Access Denied
```
