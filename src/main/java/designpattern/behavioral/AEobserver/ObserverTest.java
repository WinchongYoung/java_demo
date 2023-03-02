package designpattern.behavioral.AEobserver;

/**
 * 观察者模式(发布订阅模式)
 * 使得每当一个对象状态发生改变时，其相关依赖对象皆得到通知并被自动更新
 */
public class ObserverTest {

    public static void main(String[] args) {

        MMTikToker lei = new MMTikToker();

        lei.startSell();

        RobotFans fans1 = new RobotFans();
        RobotFans fans2 = new RobotFans();
        RobotFans fans3 = new RobotFans();
        fans1.follow(lei);
        fans2.follow(lei);
        fans3.follow(lei);

        HumanFans humanFans = new HumanFans();
        humanFans.follow(lei);

        System.out.println("=====>");


        lei.endSell();
    }
}
/**
 * 什么场景用到？
 * Spring事件机制如何实现？
 * Vue的双向绑定核心
 * 响应式编程核心思想
 */