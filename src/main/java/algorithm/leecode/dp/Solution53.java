package algorithm.leecode.dp;

/**
 * dp[i] =
 * dp[i - 1] + nums[i]，即：nums[i]加入当前连续子序列和
 * nums[i]             即：nums[i]作为头开始计算当前连续子序列和
 */
public class Solution53 {

    public static int maxSubArray(int[] nums) {
        int total = 0;
        int res = nums[0];
        for (int num : nums) {
            total = Math.max(total + num, num);
            res = Math.max(res, total);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

}
