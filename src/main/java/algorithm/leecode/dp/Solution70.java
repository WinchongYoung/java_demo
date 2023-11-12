package algorithm.leecode.dp;

public class Solution70 {
    // 递推公式:dp[i] = dp[i-1] + dp[i-2]
    // 解释: dp[i]有两周爬法，第一种是从i-1爬上来，对应dp[i-1]种情况
    // 第二种是从i-2爬上来，对应dp[i-2]种情况
    // 所以总的情况数量是dp[i-1] + dp[i-2]
    public static int steps(int nums) {
        int[] dp = new int[nums];
        if (nums >= 1) dp[0] = 1;
        if (nums >= 2) dp[1] = 2;
        for (int i = 2; i <= nums - 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[nums - 1];
    }

    public static void main(String[] args) {
        System.out.println(steps(3));
    }

}
