## 定義

爲其他物件提供一種代理以控制對這個物件的訪問。

## 代理類型  
   
- 遠程代理：
- 虛擬代理：將一個需要消耗很大資源或者比較複雜的物件延遲到真正需要時才建立。如載入圖片時，圖檔過大，先用小檔圖片Proxy來代替真正的圖片，當真實圖片載入完成後，再實際顯示給客戶端。
- 保護代理：  
- 智慧代理：  
- 快取代理：  

## 例子  
> 此範例示範保護代理，代理首先檢查您要連接的主機，如果它不是受限制網站列表的一部分，那麼它將連接到真正的網路。  
  
## 程式碼範例  
。
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

。
```java
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
```   

程式執行：  
```java
Internet internet = new ProxyInternet();
try {
    internet.connectTo("test.com");
    internet.connectTo("abc.com");
} catch (Exception e) {
    System.out.println(e.getMessage());
}
```  

輸出：  
```java
Connecting to test.com
Access Denied
```
