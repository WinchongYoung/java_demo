package algorithm.leecode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 *
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Solution77 {

    private final ArrayList<Integer> step = new ArrayList<>();

    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int n, int k, int startIndex) {
        if (step.size() == k) {
            result.add(new ArrayList<>(step));
            return;
        }
        // 剩余数量要大于需要选择的元素数量
        // n - i + 1 >= k - step.size()
        // n - k + step.size() + 1 >= i
        for (int i = startIndex; i <= n - k + step.size() + 1; i++) {
            step.add(i);
            backtracking(n, k, i + 1);
            step.remove(step.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> listList = new Solution77().combine(4, 2);
        for (List<Integer> integers : listList) {
            System.out.println(integers);
        }
    }
}
