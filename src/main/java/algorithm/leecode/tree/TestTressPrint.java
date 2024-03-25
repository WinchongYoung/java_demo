package algorithm.leecode.tree;

import algorithm.util.GetTestTree;
import algorithm.util.Node;

import java.util.LinkedList;

// 树遍历测试
public class TestTressPrint {

    // 深度优先遍历-先序遍历
    public static void printTree(Node root) {
        if (root != null) {
            System.out.println(root.data);
            printTree(root.left);
            printTree(root.right);
        }
    }

    // 广度优先遍历-层序遍历
    public static void printTree2(Node root) {
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node tmp = list.remove();
            System.out.println(tmp.data);
            if (tmp.left != null) list.add(tmp.left);
            if (tmp.right != null) list.add(tmp.right);
        }
    }

    public static void main(String[] args) {
        Node root = GetTestTree.getTestTree();
        // 层序遍历
        // printTree2(root);
        printTree(root);
    }

}
