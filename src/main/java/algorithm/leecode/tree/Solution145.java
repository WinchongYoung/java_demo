package algorithm.leecode.tree;

import algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution145 {
    //+++++++++++++++++++++后序便利-递归++++++++++++++++++++
    //
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    public void preorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        preorder(node.left, list);
        preorder(node.right, list);
        list.add(node.val);
    }

    //+++++++++++++++++++++后序便利-非递归++++++++++++++++++++

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(list);
        return list;
    }

    //+++++++++++++++++++++++++测试代码+++++++++++++++++++++++

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode root = new TreeNode(1, null, null);
        List<Integer> nodes = new Solution145().postorderTraversal2(root);
        for (Integer node : nodes) {
            System.out.println(node);
        }
    }
}
