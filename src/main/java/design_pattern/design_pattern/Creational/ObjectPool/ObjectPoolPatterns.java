package design_pattern.design_pattern.Creational.ObjectPool;

public class ObjectPoolPatterns {
    public static void UseObjectPool() {
        GiantsPool gp = new GiantsPool();
        System.out.println(gp.toString());
        Giants g1 = gp.acquire();
        System.out.println(g1.toString());
        Giants g2 = gp.acquire();
        System.out.println(g2.toString());
        Giants g3 = gp.acquire();
        System.out.println(g3.toString());
        System.out.println("before release " + gp.toString());
        gp.release(g1);
        System.out.println("release g1");
        gp.release(g2);
        System.out.println("release g2");
        System.out.println("after release " + gp.toString());
        Giants g4 = gp.acquire();
        System.out.println(g4.toString());
        Giants g5 = gp.acquire();
        System.out.println(g5.toString());
        System.out.println("after acquire " + gp.toString());
    }
}
