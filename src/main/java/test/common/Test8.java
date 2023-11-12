package test.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Test8 {
    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        System.out.println(formatBigNumber(new BigDecimal("199")));
    }

        /*BigDecimal a2 = BigDecimal.valueOf(19.22345634534124578902f);
        System.out.println(a2);
        System.out.println(a2.toPlainString());

        BigDecimal a3 = new BigDecimal("35634535255456719.22345634534124578902");
        System.out.println(a3);
        System.out.println(a3.toPlainString());*/

    public static String formatBigNumber(BigDecimal number) {
        BigDecimal tenThousand = new BigDecimal("10000");
        if (number.compareTo(tenThousand) >= 0) {
            // return number.divide(tenThousand, 3, RoundingMode.FLOOR).setScale(2, RoundingMode.FLOOR).toPlainString() + "万";
            return number.divide(tenThousand, 2, RoundingMode.FLOOR).toPlainString() + "万";
        }
        return df.format(number.setScale(2, RoundingMode.FLOOR));
    }
}
