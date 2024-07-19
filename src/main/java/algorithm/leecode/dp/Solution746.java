package algorithm.leecode.dp;

public class Solution746 {



    // dp[i] = min(dp[i-1] + nums[i - 1], dp[i-2] + nums[i - 2])
    public static int minCostClimbingStairs(int[] nums) {
        // 此处数组长度为nums.length + 1的原因是要越过所有台阶，
        // 包含数组最后一项
        int[] res = new int[nums.length + 1];
        res[0] = 0;
        res[1] = 0;
        for (int i = 2; i <= nums.length; i++) {
            res[i] = Math.min(res[i - 1] + nums[i - 1], res[i - 2] + nums[i - 2]);
        }
        return res[nums.length];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(nums));
    }

}
