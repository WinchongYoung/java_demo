package test.common;

public class Test19 {
    public static void main(String[] args) {
        Integer a = 300;
        Integer b = 400;

        System.out.println(a.equals(b));
        byte allBitsOne = (byte) 0xFF;

    }


    class InnerClass {
        Test19 test19;

        public InnerClass(Test19 test19) {
            this.test19 = test19;
        }
    }
}
