## 定義

確保一個類別只有有限數量的實例，並提供對它們的全局訪問點。

## 例子   

> 火影忍者裡的尾獸總共有九隻，從一尾到九尾。  
  
## 程式碼範例  
設定尾獸。
```java
public enum TailedBeastName {
    Shukaku, //一尾守鶴
    Matatabi, //二尾又旅
    Isobu, // 三尾磯撫
    SonGokū, // 四尾孫悟空
    Kokuō, // 五尾穆王
    Saiken, // 六尾犀犬
    Chōmei, // 七尾重明
    UshiOni, // 八尾牛鬼
    Kurama// 九尾九喇嘛
}

public final class TailedBeast {
    private static final Map<TailedBeastName, TailedBeast> beasts;
    private final TailedBeastName name;
    static {
        beasts = new ConcurrentHashMap<>();
        beasts.put(TailedBeastName.Shukaku, new TailedBeast(TailedBeastName.Shukaku));
        beasts.put(TailedBeastName.Matatabi, new TailedBeast(TailedBeastName.Matatabi));
        beasts.put(TailedBeastName.Isobu, new TailedBeast(TailedBeastName.Isobu));
        beasts.put(TailedBeastName.SonGokū, new TailedBeast(TailedBeastName.SonGokū));
        beasts.put(TailedBeastName.Kokuō, new TailedBeast(TailedBeastName.Kokuō));
        beasts.put(TailedBeastName.Saiken, new TailedBeast(TailedBeastName.Saiken));
        beasts.put(TailedBeastName.Chōmei, new TailedBeast(TailedBeastName.Chōmei));
        beasts.put(TailedBeastName.UshiOni, new TailedBeast(TailedBeastName.UshiOni));
        beasts.put(TailedBeastName.Kurama, new TailedBeast(TailedBeastName.Kurama));
    }

    private TailedBeast(TailedBeastName name) {
        this.name = name;
    }

    public static TailedBeast getInstance(TailedBeastName name) {
        return beasts.get(name);
    }

    public TailedBeastName getName() {
        return name;
    }
}
```  

程式執行：  
```java
System.out.println("OneTail= " + TailedBeast.getInstance(TailedBeastName.Shukaku));
System.out.println("TwoTail= " + TailedBeast.getInstance(TailedBeastName.Matatabi));
System.out.println("ThreeTail= " + TailedBeast.getInstance(TailedBeastName.Isobu));
System.out.println("FourTail= " + TailedBeast.getInstance(TailedBeastName.SonGokū));
System.out.println("FiveTail= " + TailedBeast.getInstance(TailedBeastName.Kokuō));
System.out.println("SixTail= " + TailedBeast.getInstance(TailedBeastName.Saiken));
System.out.println("SevenTail= " +TailedBeast.getInstance(TailedBeastName.Chōmei));
System.out.println("EightTail= " + TailedBeast.getInstance(TailedBeastName.UshiOni));
System.out.println("NineTail= " + TailedBeast.getInstance(TailedBeastName.Kurama));

System.out.println("OneTail= " + TailedBeastEnum.Shukaku);
System.out.println("TwoTail= " + TailedBeastEnum.Matatabi);
System.out.println("ThreeTail= " + TailedBeastEnum.Isobu);
System.out.println("FourTail= " + TailedBeastEnum.SonGokū);
System.out.println("FiveTail= " + TailedBeastEnum.Kokuō);
System.out.println("SixTail= " + TailedBeastEnum.Saiken);
System.out.println("SevenTail= " + TailedBeastEnum.Chōmei);
System.out.println("EightTail= " + TailedBeastEnum.UshiOni);
System.out.println("NineTail= " + TailedBeastEnum.Kurama);
```  

輸出：  
```java
OneTail= design_pattern.design_pattern.Creational.Multiton.TailedBeast@42a57993
TwoTail= design_pattern.design_pattern.Creational.Multiton.TailedBeast@75b84c92
ThreeTail= design_pattern.design_pattern.Creational.Multiton.TailedBeast@6bc7c054
FourTail= design_pattern.design_pattern.Creational.Multiton.TailedBeast@232204a1
FiveTail= design_pattern.design_pattern.Creational.Multiton.TailedBeast@4aa298b7
SixTail= design_pattern.design_pattern.Creational.Multiton.TailedBeast@7d4991ad
SevenTail= design_pattern.design_pattern.Creational.Multiton.TailedBeast@28d93b30
EightTail= design_pattern.design_pattern.Creational.Multiton.TailedBeast@1b6d3586
NineTail= design_pattern.design_pattern.Creational.Multiton.TailedBeast@4554617c
OneTail= Shukaku
TwoTail= Matatabi
ThreeTail= Isobu
FourTail= SonGokū
FiveTail= Kokuō
SixTail= Saiken
SevenTail= Chōmei
EightTail= UshiOni
NineTail= Kurama
```
