package algorithm.leecode.arr;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 */
public class Solution27 {
    public static int remove(int[] nums, int target) {
        // 记录构建新的数组的下标
        int slowIndex = 0;
        for (int faseIndex = 0; faseIndex < nums.length; faseIndex++) {
            // 如果便利的元素不等于目标值
            if (nums[faseIndex] != target) {
                //添加进构建的新的数组
                nums[slowIndex] = nums[faseIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 3, 2, 3, 4};
        int total = remove(nums, 3);
        for (int i = 0; i < total; i++) {
            System.out.println(nums[i]);
        }
    }
}
