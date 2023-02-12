package designpattern.creation.ABPrototype;

/**
 * 原型模式
 * 是用于创建重复的对象，同时又能保证性能
 */
public class PrototypeTest {
    public static void main(String[] args) {
        PrototypeAbstract prototype = ProtoCache.getShape("Prototype");
        prototype.setName("Zhangsan");
        System.out.println(prototype);

        PrototypeAbstract prototype2 = ProtoCache.getShape("Prototype2");
        System.out.println(prototype2);
    }
}

/**
 * 什么场景用到？
 * 资源优化
 * 性能和安全要求
 * 一个对象多个修改者的场景。
 * 一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时可以考虑使用原型模式拷贝多个对象供调用者使用。
 * 深（两个完全对象不一样的【递归克隆】，内容却完全一样）、浅（只是属性赋值）
 */