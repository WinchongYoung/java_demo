package algorithm.leecode.arr;

public class Solution209 {
    // 找出该数组中满足其总和--- 大于等于---  target 的长度最小的 连续子数组
    // 滑动窗口
    public static int minSubArrayLen(int s, int[] nums) {
        // 滑动窗口开始  窗口元素总和
        int start = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            // 如果窗口中的元素恰好大于等于目标值
            // 尝试缩小窗口
            while (sum >= s) {
                minLen = Math.min(end - start + 1, minLen);
                sum -= nums[start];
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen(11, nums));
    }
}
