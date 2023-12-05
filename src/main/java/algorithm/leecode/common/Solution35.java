package algorithm.leecode.common;

public class Solution35 {
    public static int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, -33));
    }
}
