package designpattern.creation.ACfactory.abstractfactory;


/**
 * 在工厂方法模式基础上，将工厂进行层层抽象
 * 可以抽象成接口（只有方法），可以抽象成抽象类（有些属性也需要用）
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {

        WulinFactory wulinFactory = new WulinWuHanMaskFactory();
        AbstractCar abstractCar = wulinFactory.newCar();

        AbstractMask abstractMask = wulinFactory.newMask();
        abstractMask.protectedMe();

        wulinFactory = new WulinHangZhouMaskFactory();
        AbstractMask abstractMask1 = wulinFactory.newMask();
        abstractMask1.protectedMe();
    }
}


/**
 * 什么场景用到？
 * NumberFormat、SimpleDateFormat
 * LoggerFactory：
 * SqlSessionFactory：MyBatis
 * BeanFactory：Spring的BeanFactory（就是为了造出bean）
 */
