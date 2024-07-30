package algorithm.leecode.tree;

import algorithm.util.GetTestTreeV2;
import algorithm.util.TreeNode;

import java.util.*;

/**
 * 二叉树的右视图
 */
public class Solution199 {

    private final List<Integer> retList = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return retList;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            int size = stack.size();
            while (size > 0) {
                TreeNode node = stack.pop();
                tmpList.add(node.val);
                if (node.left != null) stack.add(node.left);
                if (node.right != null) stack.add(node.right);
                if(size == 1)
                    retList.add(node.val);
                size--;
            }
        }
        return retList;
    }

    //+++++++++++++++++++++++++测试代码+++++++++++++++++++++++

    public static void main(String[] args) {
        TreeNode root = GetTestTreeV2.getTestTree();
        List<Integer> nodes = new Solution199().rightSideView(root);
        System.out.println(nodes);
    }
}
