package test.common;

/**
 * 由于 ThisEscape 对象在构造方法还未执行完成时，就通过匿名内部类“逸”了出去，
 * 这样外部在使用的时候，比如 doSomething 方法就拿到可能是一个还未完全完成初始化的对象，就会导致问题
 * 解决办法：使用工厂方法
 */
public class ThisEscape {

    String name;

    public ThisEscape(String name) {
        ((Runnable) () -> doSomething()).run();
        this.name = name;
    }

    void doSomething() {
        System.out.println("name = " + ThisEscape.this.name);
    }

    public static void main(String[] args) {
        new ThisEscape("haha");
    }
}
/**
 * 另：
 * 1、非静态内部类持有外部类的引用
 * 2、
 */