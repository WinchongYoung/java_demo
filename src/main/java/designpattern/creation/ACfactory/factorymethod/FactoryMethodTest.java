package designpattern.creation.ACfactory.factorymethod;

/**
 * 工厂方法
 * 在简单工厂基础上对工厂进行抽象
 * 缺点：
 *     无法拓展产品族，只能造车
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        AbstractCarFactory carFactory = new WulinRacingCarFactory();
        AbstractCar abstractCar = carFactory.newCar();
        abstractCar.run();


        carFactory = new WulinVanCarFactory();
        AbstractCar abstractCar1 = carFactory.newCar();

        abstractCar1.run();
    }
}
