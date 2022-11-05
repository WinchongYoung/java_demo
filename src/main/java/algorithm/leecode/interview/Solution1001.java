package algorithm.leecode.interview;


public class Solution1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, index = m + n - 1;
        while (index >= 0) {
            if (i < 0) {
                A[index] = B[j];
                j--;
            } else if (j < 0) {
                A[index] = A[i];
                i--;
            } else if (A[i] > B[j]) {
                A[index] = A[i];
                i--;
            } else {
                A[index] = B[j];
                j--;
            }
            index--;
        }
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,0,0,0};
        int[] B = {2,5,6};
        new Solution1001().merge(A, 3, B, 3);

        for (int key : A) {
            System.out.println(key);
        }
    }
}
