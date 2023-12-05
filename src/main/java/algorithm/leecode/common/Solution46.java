package algorithm.leecode.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution46 {
    static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        // 记录路径
        LinkedList<Integer> routs = new LinkedList<>();
        //记录是否选择
        boolean[] isChoose = new boolean[nums.length];

        backtrack(nums, routs, isChoose);
        return res;
    }

    public static void backtrack(int[] nums, LinkedList<Integer> routs, boolean[] isChoose) {

        // 退出条件
        if (routs.size() == nums.length) {
            res.add(new ArrayList<>(routs));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isChoose[i]) {
                continue;
            }

            routs.add(nums[i]);
            isChoose[i] = true;

            backtrack(nums, routs, isChoose);

            routs.removeLast();
            isChoose[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> item : permute) {
            System.out.println(item.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }

    }
}
