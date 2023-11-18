package algorithm.leecode.arr;

public class Solution977 {

    public static int[] sortedSquares(int[] nums) {
        int[] newArr = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int index = nums.length - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                newArr[index--] = nums[left] * nums[left];
                left++;
            } else {
                newArr[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        int[] result = sortedSquares(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
