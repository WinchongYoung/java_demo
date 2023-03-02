package designpattern.behavioral.ADmediator;


/**
 * 中介者模式：
 * 类的网状变为星状结构，例如飞机飞机之前通信是网状结构，飞机之间依赖塔台是星状结构
 */
public class MediatorTest {

    public static void main(String[] args) {
        HU8778 hu8778 = new HU8778();
        SC8633 sc8633 = new SC8633();

        ControlTower tower = new ControlTower();
        // 设置塔台
        hu8778.setControlTower(tower);
        sc8633.setControlTower(tower);

        hu8778.fly();
        hu8778.success();
        sc8633.fly();
    }
}
/**
 * 什么场景用到？
 * SpringMVC 的 DispatcherServlet是一个中介者，他会提取Controller、Model、View来进行调用。而无需controller直接调用view之类的渲染方法
 * 分布式系统中的网关
 * 迪米特法则的一个典型应用
 * 中介者和外观（门面）模式区别？
 * 中介者双向操作，门面偏向于封装某一方
 */