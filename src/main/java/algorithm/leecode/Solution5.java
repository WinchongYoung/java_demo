package algorithm.leecode;

public class Solution5 {
    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        boolean[][] f = new boolean[chars.length][chars.length];
        int index = 0, maxLength = 1;
        for (int j = 0; j < chars.length; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    f[i][j] = false;
                } else if (j - i <= 2) {
                    f[i][j] = true;
                } else {
                    f[i][j] = f[i + 1][j - 1];
                }
                if (f[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    index = i;
                }
            }
        }
        return s.substring(index, index + maxLength);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccba"));
    }
}
