package algorithm.leecode.dp;

public class Solution189 {
    // 递推公式:dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])
    // 解释:
    // 偷第i家，那么第i-1家不能偷，总金额等于偷前n-2家 + 第i家金额，即dp[i - 2] + nums[i]
    // 不偷第i家，那么总金额等于前i-1家的金额，即dp[i - 1]

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length >= 1) dp[0] = nums[0];
        if (nums.length >= 2) dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i <= nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(rob(nums));
    }

}
