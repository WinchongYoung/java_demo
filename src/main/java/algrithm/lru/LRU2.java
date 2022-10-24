package algrithm.lru;

import java.util.HashMap;
import java.util.Map;

public class LRU2 {

    private final Integer CAPACITY;

    private Map<Integer, Node> map;

    public Node head;

    public Node tail;

    public LRU2(Integer capacity) {
        this.CAPACITY = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public static class Node {
        public Integer key;
        public Integer value;
        public Node next;
        public Node pre;

        public Node() {
        }

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    public void set(Integer key, Integer value) {
        Node getNode = map.get(key);
        // 新增节点
        if (getNode == null) {
            if (CAPACITY == map.size()) { // 已达最大容量，删除最后一个节点
                Node lastNode = tail.pre;
                map.remove(lastNode.key);
                removeNode(lastNode);
            }
            // 新增
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            add2First(newNode);
        } else { // 更新节点
            getNode.value = value;
            removeNode(getNode);
            add2First(getNode);
        }
    }

    public Integer get(Integer key) {
        Node getNode = map.get(key);
        if (getNode == null) {
            return null;
        }
        removeNode(getNode);
        add2First(getNode);
        return getNode.value;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = null;
        node.pre = null;
    }

    private void add2First(Node node) {
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.pre = head;
        next.pre = node;
    }

    public static void main(String[] args) {
        LRU2 lru = new LRU2(3);
        lru.set(1, 1);
        lru.set(2, 2);
        lru.set(3, 3);
        lru.set(4, 4);
        lru.get(2);
        lru.print(lru.head);
    }

    public void print(LRU2.Node head) {
        LRU2.Node node = head.next;
        while (node != null && node.value != null) {
            System.out.println(node.value);
            node = node.next;
        }
        System.out.println();
    }
}
