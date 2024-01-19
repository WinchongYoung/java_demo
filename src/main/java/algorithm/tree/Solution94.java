package algorithm.tree;

import algorithm.util.GetTestTreeV2;
import algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution94 {
    //+++++++++++++++++++++中序便利-递归++++++++++++++++++++
    //
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    //+++++++++++++++++++++中序便利-非递归++++++++++++++++++++

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }

    //+++++++++++++++++++++++++测试代码+++++++++++++++++++++++

    public static void main(String[] args) {
        TreeNode root = GetTestTreeV2.getTestTree();
        List<Integer> nodes = new Solution94().inorderTraversal2(root);
        for (Integer node : nodes) {
            System.out.println(node);
        }
    }
}
