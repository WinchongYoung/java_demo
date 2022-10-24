package algrithm.lru;

import java.util.HashMap;
import java.util.Map;

public class LRU {

    private final Integer CAPACITY;

    private final Map<Integer, Node> map;

    public final Node head;

    public final Node tail;

    public LRU(Integer capacity) {
        this.CAPACITY = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>(capacity);
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
        // 新增
        if (getNode == null) {
            if (CAPACITY == map.size()) {
                Node lastNode = tail.pre;
                map.remove(lastNode.key);
                lastNode.pre.next = tail;
                tail.pre = lastNode.pre;
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            add2First(newNode);
        } else { // 更新
            getNode.value = value;
            move2First(getNode);
        }
    }

    public Integer get(Integer key) {
        Node getNode = map.get(key);
        if (getNode == null) return null;
        move2First(getNode);
        return getNode.value;
    }

    private void add2First(Node node) {
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.pre = head;
        next.pre = node;
    }

    private void move2First(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        add2First(node);
    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.set(1, 1);
        lru.set(2, 2);
        lru.set(3, 3);
        lru.set(4, 5);
        lru.set(3, 100);
        System.out.println(lru.get(4));
        lru.print(lru.head);
    }

    public void print(Node head) {
        Node node = head.next;
        while (node != null && node.value != null) {
            System.out.println(node.value);
            node = node.next;
        }
        System.out.println();
    }
}
