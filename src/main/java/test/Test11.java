package test;

public class Test11 {


    public static void main(String[] args) {
        int[] nums = {4, 2, 7, 1, 5};
        bubbleSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}


