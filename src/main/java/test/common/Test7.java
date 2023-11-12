package test.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Test7 {
    public static void main(String[] args) {
        BigDecimal d1 = new BigDecimal("123.455");
        BigDecimal d2 = new BigDecimal("123.4500");

        // System.out.println(d1.setScale(2, BigDecimal.ROUND_HALF_UP));

        BigDecimal x = new BigDecimal("10");
        BigDecimal y = new BigDecimal("3");
        BigDecimal result = x.divide(y, 6, RoundingMode.HALF_UP);
        System.out.println(result);

    }
}
