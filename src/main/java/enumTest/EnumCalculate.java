package enumTest;

/**
 * Enum结合Lambda表达式，实现两个整数的四则运算
 */
public class EnumCalculate {

    public static void main(final String[] args) throws Exception {
        int result = Operation.ADD.apply(2, 3);
        System.out.println(result);
    }

}