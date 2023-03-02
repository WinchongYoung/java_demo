package test.generic.clazz;

public class GenericTest {
    public static void main(String[] args) {
        // 在使用泛型的时候如果传入泛型实参，则会根据传入的泛型实参做相应的限制，
        // 此时泛型才会起到本应起到的限制作用。如果不传入泛型类型实参的话，
        // 在泛型类中使用泛型的方法或成员变量定义的类型可以为任何的类型。
        Generic a = new Generic<>("100");
        Generic b = new Generic<>(100);
        System.out.println(a.getKey());
        System.out.println(b.getKey());
    }

}
