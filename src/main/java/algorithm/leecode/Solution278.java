package algorithm.leecode;

public class Solution278 {
    public static int firstBadVersion(int n) {
        int left = 1;
        while (left < n) {
            int middle = ((n - left) >> 1) + left;
            if (isBadVersion(middle)) {
                n = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public static boolean isBadVersion(int version) {
        int[] nums = new int[]{0, 0, 0, 0, 1, 1};
        if (version > 5) {
            return true;
        }
        return nums[version - 1] == 1;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(4));
    }
}
