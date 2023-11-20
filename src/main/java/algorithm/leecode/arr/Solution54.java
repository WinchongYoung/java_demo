package algorithm.leecode.arr;

public class Solution54 {
    // (0,0)  t
    //  +-----------+
    //  |           |
    // l|           |r
    //  |           |
    //  +—----------+ (n-1,n-1)
    //        b
    // t表示上边界，上边界由上到下移动，横坐标增大，横坐标初始为0
    // r表示右边界，右边界由右到左移动，纵坐标变小，纵坐标初始为n-1
    // ... 以此类推
    public static int[][] generateMatrix(int num) {
        int[][] result = new int[num][num];
        int t = 0, r = num - 1, b = num - 1, l = 0;
        int totalNum = num * num;
        int n = 1;
        while (n <= totalNum) {
            for (int i = l; i <= r; i++) {
                result[t][i] = n++;
            }
            t++;

            for (int j = t; j <= b; j++) {
                result[j][r] = n++;
            }
            r--;

            for (int i = r; i >= l; i--) {
                result[b][i] = n++;
            }
            b--;

            for (int i = b; i >= t; i--) {
                result[i][l] = n++;
            }
            l++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        for (int[] ints : matrix) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
