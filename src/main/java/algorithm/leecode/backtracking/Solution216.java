package algorithm.leecode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 */
public class Solution216 {

    private final LinkedList<Integer> path = new LinkedList<>();
    private final List<List<Integer>> ans = new ArrayList<>();
    private Integer sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return ans;
    }

    // k个和为n的元素
    private void backtracking(int k, int n, int startIndex) {
        // 剪枝 和大于
        if (sum > n) return;

        if (path.size() > k) return;

        if (sum == n && path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            sum += i;
            backtracking(k, n, i + 1);
            sum -= i;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> listList = new Solution216().combinationSum3(2, 7);
        for (List<Integer> integers : listList) {
            System.out.println(integers);
        }
    }
}
