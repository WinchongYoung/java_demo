package algorithm.redenvelope;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * 实现微信红包
 * 二倍均值法
 * 二倍均值计算公式：2 * 剩余金额/剩余红包数
 * 思想：认为每次计算红包的金额，介于0和2倍剩余红包均值之间
 * 第一个红包金额一定小于20？
 */
public class RedEnvelope {
    public static void main(String[] args) {
        BigDecimal[] result = new RedEnvelope().redEnvelopeGen(new BigDecimal("10"), new BigDecimal("100.00"), new BigDecimal("0.01"));
        for (BigDecimal decimal : result) {
            System.out.println(decimal);
        }
    }

    /**
     * @param num    红包总数
     * @param amount 红包总金额
     * @param min    最小红包金额
     * @return 红包数组
     */
    public BigDecimal[] redEnvelopeGen(BigDecimal num, BigDecimal amount, BigDecimal min) {
        BigDecimal remain = amount.subtract(min.multiply(num));
        final Random random = new Random();
        final BigDecimal hundred = new BigDecimal("100");
        final BigDecimal two = new BigDecimal("2");
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal[] result = new BigDecimal[num.intValue()];
        BigDecimal redpeck;
        for (int i = 0; i < num.intValue(); i++) {
            final int nextInt = random.nextInt(100); // 产生介于0(含)和n(不含)伪随机数
            if (i == num.intValue() - 1) {
                redpeck = remain;
            } else {
                // redpeck = nextInt * （remain * 2 / (num - i)）/ hundred
                redpeck = new BigDecimal(nextInt).multiply(remain.multiply(two).divide(num.subtract(new BigDecimal(i)), 2, RoundingMode.CEILING)).divide(hundred, 2, RoundingMode.FLOOR);
            }
            if (remain.compareTo(redpeck) > 0) {
                // ramain = ramain - erdpeck
                remain = remain.subtract(redpeck).setScale(2, BigDecimal.ROUND_HALF_UP);
            } else {
                remain = BigDecimal.ZERO;
            }
            sum = sum.add(min.add(redpeck)).setScale(2, BigDecimal.ROUND_HALF_UP);
            result[i] = min.add(redpeck);
        }
        return result;
    }

}
