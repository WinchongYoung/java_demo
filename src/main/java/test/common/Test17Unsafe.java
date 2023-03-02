package test.common;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 通过反射获取Unsafe类
 * 详见:https://tech.meituan.com/2019/02/14/talk-about-java-magic-class-unsafe.html
 */
public class Test17Unsafe {
    public static void main(String[] args) {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe unsafe = (Unsafe) field.get(null);
            System.out.println(unsafe);
        } catch (NoSuchFieldException | IllegalAccessException noSuchFieldException) {
            noSuchFieldException.printStackTrace();
        }
    }
}
