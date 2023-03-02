package designpattern.behavioral.AAtemplate;

public class TemplateTest {

    public static void main(String[] args) {
        AutoCookMachine cookMachine = new AutoCookMachine();
        cookMachine.cook();

    }
}
/**
 * 什么场景用到？
 * Spring的整个继承体系都基本用到模板方法;
 * BeanFactory.getBean(1,2,3,4)--A1---A2---A3---A4（全部被完成）
 * JdbcTemplate、RedisTemplate都允许我们再扩展.....
 * 我们自己的系统也应该使用模板方法组织类结构
 * ......
 */