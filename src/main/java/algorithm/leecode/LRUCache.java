package algorithm.leecode;

import java.util.HashMap;

public class LRUCache {

    public Integer capacity;
    public HashMap<Integer, Node> map = new HashMap<>();
    public Node head;
    public Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node tmp = map.get(key);
        if (tmp == null) {
            return -1;
        }
        // 将元素移到数组开始
        removeNode(tmp);
        move2Head(tmp);
        return tmp.value;
    }

    public void put(int key, int value) {
        Node tmp = map.get(key);
        if (tmp != null) {
            tmp.value = value;
            removeNode(tmp);
            move2Head(tmp);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            move2Head(node);
        }
        if (map.size() > capacity) {
            map.remove(tail.pre.key);
            removeNode(tail.pre);
        }
    }

    public static class Node {
        public Node next;
        public Node pre;
        public Integer key;
        public Integer value;

        public Node() {
        }

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    void move2Head(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

}
