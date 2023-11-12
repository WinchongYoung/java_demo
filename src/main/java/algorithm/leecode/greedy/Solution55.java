package algorithm.leecode.greedy;

public class Solution55 {

    // 贪心
    public static boolean isReachLast(int[] nums) {
        // 表示能跳到最远的数组下标
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(i + nums[i], cover);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 0, 2};
        System.out.println(isReachLast(nums));
        int[] nums2 = new int[]{3, 2, 1, 0, 2};
        System.out.println(isReachLast(nums2));
    }

}
