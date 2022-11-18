package design_pattern.design_pattern.Creational.ObjectPool;

public class ObjectPoolPatterns {
    public static void UseObjectPool() {
        System.out.println("UseObjectPool");
        GiantsPool _GiantsPool = new GiantsPool();
        System.out.println(_GiantsPool.toString());
        Giants g1 = _GiantsPool.acquire();
        System.out.println(g1.toString());
        Giants g2 = _GiantsPool.acquire();
        System.out.println(g2.toString());
        Giants g3 = _GiantsPool.acquire();
        System.out.println(g3.toString());
        System.out.println("before release " + _GiantsPool.toString());
        _GiantsPool.release(g1);
        _GiantsPool.release(g2);
        System.out.println("after release " + _GiantsPool.toString());
        Giants g4 = _GiantsPool.acquire();
        System.out.println(g4.toString());
        Giants g5 = _GiantsPool.acquire();
        System.out.println(g5.toString());
        System.out.println("after acquire " + _GiantsPool.toString());
    }
}
