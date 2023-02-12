package designpattern.creation.ACfactory.simplefactory;

/**
 * 简单工厂模式
 * 适用于产品数量较少的产品
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {

        WuLinSimpleFactory factory = new WuLinSimpleFactory();
        AbstractCar van = factory.newCar("van");
        AbstractCar mini = factory.newCar("mini");
        van.run();
        mini.run();
    }
}
