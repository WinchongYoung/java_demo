package test.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test10 {
    static class Node {

        public Integer data;

        public Node(Integer data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        Map<Node, Node> map = new HashMap<>();
        map.put(node1, node2);
        map.put(node2, node3);
        map.put(node3, node1);



    }

    public static void printGraph(Map<Node, Node> nods) {
        Arrays.sort(new int[]{1, 2, 3});
    }

}


