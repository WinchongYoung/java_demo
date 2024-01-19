package algorithm.util;

public class GetTestTreeV2 {

    /**
     *  构造测试二叉树
     *      1
     *     / \
     *    2   3
     *       / \
     *      4   5
     */
    public static TreeNode getTestTree() {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3, node4, node5);
        TreeNode node2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, node2, node3);
        return root;
    }
}
