package algorithm.util;

public class GetTestTree {


    /**
     * 构造测试用二叉树
     *      1
     *    /   \
     *   2    3
     *  / \   /
     * 4   5 6
     *
     * @return
     */
    public static Node getTestTree() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        return node1;
    }
}
