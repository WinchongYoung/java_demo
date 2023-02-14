package designpattern.creation.ADbuilder;

public class BuilderTest {
    public static void main(String[] args) {
        PhoneBuilder abstractBuilder = new PhoneBuilder();
        Phone phone = abstractBuilder
                .setDisk("1TB")
                .setCPU("888")
                .setMem("128G")
                .build();
        System.out.println(phone);
    }

}
