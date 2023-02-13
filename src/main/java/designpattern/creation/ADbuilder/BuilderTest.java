package designpattern.creation.ADbuilder;

public class BuilderTest {
    public static void main(String[] args) {
        AbstractBuilder abstractBuilder = new PhoneBuilder();
        Product phone = abstractBuilder.setDisk("disk").build();
        System.out.println(phone);
    }

}
