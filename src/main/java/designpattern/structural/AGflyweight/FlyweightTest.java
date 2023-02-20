package designpattern.structural.AGflyweight;


/**
 * 享元模式
 * 享元和原型
 * 1、享元返回的是这个本人。
 * 2、原型返回的是克隆人。
 * <p>
 * 享元模式的核心在于抽取可共享元素的可共享和不可共享特性
 * 并针对不可共享的元素提供可以 改变/获取 共享状态的方法
 */
public class FlyweightTest {

    public static void main(String[] args) {

        //1、我
        AbstractWaitressFlyweight waitress = ZuDao.getWaitress("");
        waitress.service();
        System.out.println(waitress);
        //2、佟老师
        AbstractWaitressFlyweight waitress1 = ZuDao.getWaitress("");
        waitress1.service();
        System.out.println(waitress1);

        waitress1.end();
        //3、刘佳林
        AbstractWaitressFlyweight waitress2 = ZuDao.getWaitress("");
        System.out.println(waitress2);

    }
}
/**
 * 什么场景用到？
 * 典型的代表：数据库连接池
 * 所有的池化技术
 * 享元和原型模式有什么区别？享元是预先准备好的对象进行复用，原型没法确定预先有哪些
 */
