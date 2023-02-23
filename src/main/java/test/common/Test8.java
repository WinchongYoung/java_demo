package test.common;

import java.math.BigDecimal;

public class Test8 {
    public static void main(String[] args) {
        BigDecimal a2 = BigDecimal.valueOf(19.22345634534124578902f);
        System.out.println(a2);
        System.out.println(a2.toPlainString());

        BigDecimal a3 = new BigDecimal("35634535255456719.22345634534124578902");
        System.out.println(a3);
        System.out.println(a3.toPlainString());
    }
}
