package designpattern.creation.ACfactory.simplefactory;


/**
 * 简单工厂
 * 1、产品数量极少
 */
public class WuLinSimpleFactory {

    /**
     * @param type Class: 好像具有扩展性，但是没有解决实际问题
     * @return
     */
    public AbstractCar newCar(String type) {
        AbstractCar car = null;
        switch (type) {
            case "van":
                car = new VanCar();
                break;
            case "mini":
                car = new MiniCar();
                break;
            default:
        }
        return car;
    }
}
