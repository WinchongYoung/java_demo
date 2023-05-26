package test.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Test20 {

    public static void main(String[] args) {
        int[] weights = new int[3];
        weights[0] = 60;
        weights[1] = 60;
        weights[2] = 60;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            result.add(balance(weights));
        }
        Map<Integer, Long> map = result.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        map.forEach((x, v) -> System.out.println(x + "->" + v));
    }

    public static int balance(int[] weight) {
        int[] weights = new int[weight.length];
        System.arraycopy(weight, 0, weights, 0, weight.length);
        int totalWeight = 0;
        Random random = new Random();
        for (int i = 0; i < weights.length; i++) {
            weights[i] += totalWeight;
            totalWeight = weights[i];
        }
        int threshold = random.nextInt(weights[weights.length - 1]);
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] >= threshold) {
                return i;
            }
        }
        return -1;
    }
}
/**
 * 另：
 * 参考Dubbo
 * RandomLoadBalance
 */
