package designpattern.structural.AAadapter.obj;


import designpattern.structural.AAadapter.MoviePlayer;

/**
 * 将一个接口转换成客户希望的另一个接口
 * 适配器模式使接口不兼容的那些类可以一起工作
 * 适配器模式分为类结构型模式（继承）和对象结构型模式（组合）两种
 * 组合使用较多
 */
public class MainTest {
    public static void main(String[] args) {
        JPMoviePlayerAdapter adapter = new JPMoviePlayerAdapter(new MoviePlayer());
        adapter.play();
    }
}

/**
 * 适配器模式（Adapter）包含以下主要角色。
 * 目标（Target）接口：可以是抽象类或接口。客户希望直接用的接口
 * 适配者（Adaptee）类：隐藏的转换接口
 * 适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口。
 */


/**
 * 什么场景用到？
 * Tomcat如何将Request流转为标准Request；
 * tomcat.Request接口
 * servlet.Request接口
 * tomcat ===  CoyoteAdapte === ServletRequest
 * Spring AOP中的AdvisorAdapter是什么：增强的适配器
 * 前置、后置、返回、结束  Advisor（通知方法）
 * 底层真的目标方法
 * Spring MVC中经典的HandlerAdapter是什么；
 * HelloController.hello()
 * HandlerAdapter
 * Servlet.doGet()
 * SpringBoot 中 WebMvcConfigurerAdapter为什么存在又取消
 * ......
 */