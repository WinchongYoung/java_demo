package designpattern.structural.ACdecorator;


/**
 * 核心：想要不改变原来接口方法的情况下扩展新功能，或者增强方法.....
 */
public class DecoratorTest {

    public static void main(String[] args) {
        //被装饰对象
        ManTikTok manTikTok = new LeiTikTok();
//        manTikTok.tiktok();

        /**
         *  LiMingTiktokProxy proxy = new LiMingTiktokProxy(new LeiTikTok());
         *         proxy.tiktok();
         */

        MeiYanDecorator decorator = new MeiYanDecorator(manTikTok);
        decorator.tiktok();
    }
}

/**
 * 什么场景使用？
 * 无处不在.....
 * SpringSession中如何进行session与redis关联？HttpRequestWrapper
 * session：数据存在了内存
 * session：数据存在redis
 * HttpSession；getAttribute();
 * Wrapper(session){
 * getAttribute(String param){    redis.get(param) };
 * }
 * MyBatisPlus提取了QueryWrapper，这是什么？
 * Spring中的BeanWrapper是做什么？包装了Bean。bean的功能增强？
 * Spring Webflux中的 WebHandlerDecorator？
 * 已存的类，每一天在某个功能使用的时候发现不够，就可以装饰器。
 * ......
 */