package designpattern.creation.AAsingleton;

public class TestSingleton {
    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.INSTANCE;
        instance.doSomething();
    }
}
