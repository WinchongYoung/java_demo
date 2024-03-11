package algorithm.common;

/**
 * 牛顿迭代法求平方根
 */
public class TestSq {

    public static void main(String[] args) {
        System.out.println(sqrt(2, 2));
        System.out.println(Math.sqrt(2f));
    }

    static float sqrt(float cap, int m) {
        if (cap == 0) return 0;
        if (cap < 0) return -1;
        for (int i = 0; i < 5; i++) {
            cap = (cap + m / cap) / 2.0f;
        }
        return cap;
    }
}