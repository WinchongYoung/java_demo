package test.common;

public class ThisFinally {

    public static void main(String[] args) {
        Integer i = testFinally();
        System.out.println(i);
    }

    public static Integer testFinally() {
        Integer a = 1;
        try {
            a = 3;
            return a;
        } catch (Throwable e) {
            return a;
        } finally {
            a = 2;
            System.out.println("finally");
        }
    }
}