package algorithm.leecode;

public class Solution53 {


    public static int maxSubArray(int[] nums) {
        int total = nums[0], max = nums[0];
        for (int num : nums) {
            total = Math.max(num, num + total);
            max = Math.max(max, total);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));

    }
}
