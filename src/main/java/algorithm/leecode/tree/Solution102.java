package algorithm.leecode.tree;

import algorithm.util.GetTestTreeV2;
import algorithm.util.TreeNode;

import java.util.*;

/**
 * 二叉树层序遍历
 */
public class Solution102 {

    private final List<List<Integer>> retList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)) return retList;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            // size用来记录每一层需要遍历的节点个数，当遍历size次后
            // 当前层的下一层已经全部放入队列里了，依次循环
            int size = que.size();
            while (size > 0) {
                TreeNode treeNode = que.poll();
                tmpList.add(treeNode.val);
                if (Objects.nonNull(treeNode.left)) que.add(treeNode.left);
                if (Objects.nonNull(treeNode.right)) que.add(treeNode.right);
                size--;
            }
            retList.add(tmpList);
        }
        return retList;
    }

    //+++++++++++++++++++++++++测试代码+++++++++++++++++++++++

    public static void main(String[] args) {
        TreeNode root = GetTestTreeV2.getTestTree();
        List<List<Integer>> nodes = new Solution102().levelOrder(root);
        for (List<Integer> list : nodes) {
            System.out.println(list);
        }
    }
}
