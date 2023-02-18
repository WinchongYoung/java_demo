package designpattern.structural.ABbridge;

/**
 * 将抽象与实现解耦，使两者都可以独立变化，省去了创建很多类
 * 注意：桥接模式在设计时就要考虑到(适配器模式则无需)
 */
public class BridgeTest {

    public static void main(String[] args) {

        IPhone iPhone = new IPhone();
        iPhone.setSale(new StudentSale("学生", 1));

        String phone = iPhone.getPhone();
        System.out.println(phone);
    }
}

/**
 * 在现实生活中，某些类具有两个或多个维度的变化，如图形既可按形状分，又可按颜色分。
 * 如何设计类似于 Photoshop 这样的软件，能画不同形状和不同颜色的图形呢？
 * 如果用继承方式，m 种形状和 n 种颜色的图形就有 m×n 种，不但对应的子类很多，
 * 而且扩展困难。不同颜色和字体的文字、不同品牌和功率的汽车
 * 桥接将继承转为关联，降低类之间的耦合度，减少代码量
 * <p>
 * 桥接（Bridge）模式包含以下主要角色。
 * 系统设计期间，如果这个类里面的一些东西，会扩展很多，这个东西就应该分离出来
 * 抽象化（Abstraction）角色：定义抽象类，并包含一个对实现化对象的引用。
 * 扩展抽象化（Refined Abstraction）角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法。
 * 实现化（Implementor）角色：定义实现化角色的接口，供扩展抽象化角色调用。
 * <p>
 * 什么场景用到？
 * 当一个类存在两个独立变化的维度，且这两个维度都需要进行扩展时。
 * 当一个系统不希望使用继承或因为多层次继承导致系统类的个数急剧增加时。
 * 当一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性时。
 * InputStreamReader桥接模式。An InputStreamReader is a bridge from byte streams to character streams:
 * InputStreamReader 桥接+适配器
 */
