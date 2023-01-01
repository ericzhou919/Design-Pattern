package design_pattern.design_pattern.Creational.Multiton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
