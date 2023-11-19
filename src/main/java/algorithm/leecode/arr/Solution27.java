package algorithm.leecode.arr;

public class Solution27 {
    public static int remove(int[] nums, int target) {
        int slowIndex = 0;
        for (int faseIndex = 0; faseIndex < nums.length; faseIndex++) {
            if (nums[faseIndex] != target) {
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
