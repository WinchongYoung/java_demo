package designpattern.structural.ADproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 1、使用cglib帮我们创建出代理对象
 */
public class CglibProxy {

    //为任意对象创建代理
    public static <T> T createProxy(T t) {
        //1、创建一个增强器
        Enhancer enhancer = new Enhancer();

        //2、设置要增强哪个个类的功能。增强器为这个类动态创建一个子类
        enhancer.setSuperclass(t.getClass());

        //3、设置回调
        //为了能获取到原方法的一些元数据信息
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            //编写拦截的逻辑
            System.out.println("cglib上场le .......xxx");
            //当前方法的信息
//                method.get
//                method.getAnnotation()
            //目标方法进行执行
            return proxy.invokeSuper(obj, args);
        });

        Object o = enhancer.create();
        return (T) o;
    }

}

/**
 * 什么场景用到？
 * MyBatis的mapper到底是什么？怎么生成的？
 * 动态代理
 * UserMapper、CityMapper，mybatis帮我们写实现MapperProxy
 * Alibaba Seata的DataSourceProxy是什么？
 * DruidDataSource存在的Proxy模式
 * 监控链...
 * ......
 * <p>
 * <p>
 * 装饰器、代理：
 * 装饰器和代理之间的区别很细微，可以认为装饰器是代理的一个子集。
 * 静态代理就是装饰器的方式
 */
