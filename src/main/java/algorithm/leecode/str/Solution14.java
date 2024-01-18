package algorithm.leecode.str;

/**
 * 最长公共前缀
 * 示例 ：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 */
public class Solution14 {

    public static void main(String[] args) {
        String[] str = new String[]{"abcd", "abd", "abbb"};
        System.out.println(new Solution14().longestCommonPrefix(str));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 初始化最长为数组第一个元素
        String res = strs[0];
        // 从第二个开始依次和最长的元素比较
        for (int i = 1; i < strs.length; i++) {
            // 比较的字符的下标
            int index = 0;
            // 最长的字符串和当前元素比较，找到最长的字符串的最长公共前缀下标
            while (index < strs[i].length() && index < res.length() && strs[i].charAt(index) == res.charAt(index)) {
                index++;
            }
            // 更新最长字符串为上次比较完成的最长公共前缀
            res = res.substring(0, index);
        }
        return res;
    }

}
