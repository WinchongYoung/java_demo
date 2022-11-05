package algorithm.sort;

public class SelectionSort {

    public static void selectSort(int[] nums) {
        // 记录每躺比较的最小值的下标
        int minIndex;
        for (int i = 0; i < nums.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                BubbleSort.swap(nums, i, minIndex);
            }
        }
    }

    public static void selectSort2(int[] a) {
        int min;
        for (int i = 0; i < a.length; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min])
                    min = j;
            }
            if (min != i) {
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 8, 1, 9, 4, 6};
        selectSort(nums);
        for (int t : nums) {
            System.out.println(t);
        }
    }
}
