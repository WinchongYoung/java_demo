package designpattern.creation.ABPrototype;

import java.util.Hashtable;

/**
 * 保存原型模板的类
 */
public class ProtoCache {

    final private static Hashtable<String, PrototypeAbstract> shapeMap = new Hashtable<>();

    public static PrototypeAbstract getShape(String shapeId) {
        PrototypeAbstract cachedShape = shapeMap.get(shapeId);
        return (PrototypeAbstract) cachedShape.clone();
    }

    static {
        PrototypeAbstract prototype = new Prototype();
        shapeMap.put("Prototype", prototype);

        PrototypeAbstract prototype2 = new Prototype();
        prototype2.setName("DefaultName");
        shapeMap.put("Prototype2", prototype2);
    }
}