package algorithm.sort;

public class BubbleSort {
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 8, 1, 9, 4, 6};
        bubbleSort2(nums);
        for (int t : nums) {
            System.out.println(t);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void bubbleSort2(int[] nums) {
        boolean isExchange;
        for (int i = 0; i < nums.length; i++) {
            isExchange = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    isExchange = true;
                }
            }
            if (!isExchange) {
                break;
            }
        }
    }


    public static void bubbleSort3(int[] a) {
        int i, j;
        int flag;                 // 标记

        for (i = a.length - 1; i > 0; i--) {

            flag = 0;            // 初始化标记为0
            // 将a[0...i]中最大的数据放在末尾
            for (j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    // 交换a[j]和a[j+1]
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;

                    flag = 1;    // 若发生交换，则设标记为1
                }
            }

            if (flag == 0)
                break;            // 若没发生交换，则说明数列已有序。
        }
    }
}
