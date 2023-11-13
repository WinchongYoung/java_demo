package algorithm.leecode.dp;

public class Solution213 {

    // 分两周情况
    // 第一种:从0-nums.length-2家里偷
    // 第二种:从1-nums.length家里偷
    // 就可以把问题转化为第189个问题

    public static int rob(int[] nums) {
        if (nums == null) return 0;
        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(doRob(nums, 0, length - 2), doRob(nums, 1, length - 1));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 3, 1, 3, 1};
        System.out.println(rob(nums));
    }

    public static int doRob(int[] nums, int startIndex, int endIndex) {
        int[] dp = new int[endIndex - startIndex + 1];
        dp[0] = nums[startIndex];
        if (endIndex - startIndex + 1 >= 2) dp[1] = Math.max(nums[startIndex], nums[startIndex + 1]);
        for (int i = startIndex + 2; i <= endIndex - startIndex; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[endIndex - startIndex];
    }

}
