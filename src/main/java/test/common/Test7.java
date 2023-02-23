package test.common;

import java.math.BigDecimal;

public class Test7 {
    public static void main(String[] args) {
        BigDecimal d1 = new BigDecimal("123.45");
        BigDecimal d2 = new BigDecimal("123.4500");
        System.out.println(d1.compareTo(d2));
        int a = 1, b = 2, c = 3, d = 4;
        System.out.println(a & 1);
        System.out.println(b & 1);
        System.out.println(c & 1);
        System.out.println(d & 1);
    }
}
