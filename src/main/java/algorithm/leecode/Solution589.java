package algorithm.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * N 叉树的前序遍历
 * https://leetcode.cn/problems/n-ary-tree-preorder-traversal/
 */
public class Solution589 {


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private List<Integer> list = new ArrayList<>();

    // 递归
    public List<Integer> preorder(Node root) {
        if (root != null) {
            list.add(root.val);
            for (Node node : root.children) {
                preorder(node);
            }
        }
        return list;
    }

    private Stack<Node> stack = new Stack<>();
    // 非递归
    public List<Integer> preorder2(Node root) {
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            for (int i = node.children.size() - 1; i > 1; i--) {
                stack.push(node.children.get(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
