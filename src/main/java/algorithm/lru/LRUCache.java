package algorithm.lru;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    // 双向链表节点
    static class MyLinkedNode {
        private int key;
        private int value;
        MyLinkedNode prev;
        MyLinkedNode next;

        MyLinkedNode() {
        }

        MyLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Map，用于定位指定key的节点在链表中的位置
    private Map<Integer, MyLinkedNode> cache;
    // 头、尾节点
    private MyLinkedNode head, tail;
    // 实际元素个数
    private int size;
    // 容量
    private int capacity;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new MyLinkedNode();
        tail = new MyLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // 先获取到对应节点
        MyLinkedNode node = cache.get(key);
        // 不存在
        if (node == null) {
            return -1;
        }
        // 先删除链表中的该节点
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // 将其放到链表头部，表示最近使用的元素
        move2head(node);
        return node.value;
    }

    public void put(int key, int value) {
        // 先获取对应节点
        MyLinkedNode node = cache.get(key);
        // 不存在
        if (node == null) {
            // 新建节点
            MyLinkedNode newNode = new MyLinkedNode(key, value);
            // 放入Map
            cache.put(key, newNode);
            size++;
            // 判断是否到达上限
            if (size > capacity) {
                // 先删除最久未使用的数据，即链表尾部
                MyLinkedNode n = tail.prev;
                n.prev.next = tail;
                tail.prev = n.prev;
                cache.remove(n.key);
                size--;
            }
            // 放入链表头部
            move2head(newNode);
        } else { // 存在
            // 更新值
            node.value = value;
            // 先删除链表中的该节点
            node.prev.next = node.next;
            node.next.prev = node.prev;
            // 放到链表头部
            move2head(node);
        }
    }

    private void move2head(MyLinkedNode node) {
        //放到头部
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}