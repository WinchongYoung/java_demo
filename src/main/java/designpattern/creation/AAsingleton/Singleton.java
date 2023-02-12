package designpattern.creation.AAsingleton;

/**
 * 单例模式
 */
public class Singleton {

    // 饿汉
    private volatile static Singleton instance;  //饿汉

    // 构造器私有，外部不能实例化
    private Singleton() {
        System.out.println("创建了Person");
    }

    // 提供给外部的方法
    // 1、public static synchronized Singleton getSingleton() 锁粒度太大
    // 2、双重检查锁+内存可见性（设计模式）
    public static Singleton getSingleton() {
        //如果没有再去创建
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    Singleton singleton = new Singleton();
                    //多线程问题
                    instance = singleton;
                }
            }
        }
        return instance;
    }

}

/**
 * 单例的使用场景
 * 1、多线程的线程池
 * 2、数据库的连接池
 * 3、系统的环境信息 System.getProperties();
 * 4、上下文
 *
 * 面试问题
 * 系统环境信息（System.getProperties()）？
 * Spring中怎么保持组件单例的？
 * ServletContext是什么（封装Servlet的信息）？是单例吗？怎么保证？
 * ApplicationContext是什么？是单例吗？怎么保证？
 * ApplicationContext： tomcat：一个应用（部署的一个war包）会有一个应用上下文
 * ApplicationContext： Spring：表示整个IOC容器（怎么保证单例的）。ioc容器中有很多组件（怎么保证单例）
 * 数据库连接池一般怎么创建出来的，怎么保证单实例？
 */
