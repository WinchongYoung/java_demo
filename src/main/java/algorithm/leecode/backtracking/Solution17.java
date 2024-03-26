package algorithm.leecode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Solution17 {

    private StringBuilder str = new StringBuilder();

    private final List<String> ans = new ArrayList<>();

    private final List<List<String>> numMapping = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(Objects.isNull(digits) || digits.isEmpty()){
            return ans;
        }
        numMapping.add(new ArrayList<>());
        numMapping.add(new ArrayList<>());
        numMapping.add(new ArrayList<>(Arrays.asList("a", "b", "c")));
        numMapping.add(new ArrayList<>(Arrays.asList("d", "e", "f")));
        numMapping.add(new ArrayList<>(Arrays.asList("g", "h", "i")));
        numMapping.add(new ArrayList<>(Arrays.asList("j", "k", "l")));
        numMapping.add(new ArrayList<>(Arrays.asList("m", "n", "o")));
        numMapping.add(new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        numMapping.add(new ArrayList<>(Arrays.asList("t", "u", "v")));
        numMapping.add(new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
        char[] charNum = digits.toCharArray();
        List<List<String>> nums = new ArrayList<>();
        for (char c : charNum) {
            nums.add(numMapping.get(Integer.parseInt(c + "")));
        }
        backtracking(nums, 0);
        return ans;
    }

    private void backtracking(List<List<String>> charNum, int num) {

        if (str.length() == charNum.size()) {
            ans.add(str.toString());
            return;
        }

        List<String> chars = charNum.get(num);
        for (String aChar : chars) {
            str.append(aChar);
            backtracking(charNum, num + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = new Solution17().letterCombinations("23");
        for (String s : list) {
            System.out.println(s);
        }

    }
}
