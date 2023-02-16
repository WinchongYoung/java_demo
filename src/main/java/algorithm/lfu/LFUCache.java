package algorithm.lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;

class LFUCache {
    // key -> (freq, value)
    HashMap<Integer, Node> keyToNode;
    // freq -> [key]
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeySet;
    // 记录最小的频次
    int minFreq;
    // 容量
    int capacity;

    public LFUCache(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("illegal capacity");
        }
        keyToNode = new HashMap<>();
        freqToKeySet = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }
        // 获取数据
        int ret = keyToNode.get(key).data;

        // 更新最小频次
        LinkedHashSet<Integer> minFreqKeys = freqToKeySet.get(minFreq);
        // 最小频次是当前key 且 该频次下只有一条记录，此时才更新
        if (key == minFreqKeys.iterator().next() && minFreqKeys.size() == 1) {
            minFreq++;
        }

        // 更新keyToNode
        int originFre = keyToNode.get(key).freq;
        keyToNode.put(key, new Node(key, originFre + 1));

        // 更新 freqToKeySet
        LinkedHashSet<Integer> keys = freqToKeySet.get(originFre);
        keys.remove(originFre);
        // freqToKeySet 中 originFre + 1频次已存在则新增元素
        if (freqToKeySet.containsKey(originFre + 1)) {
            freqToKeySet.get(originFre + 1).add(key);
        } else {
            // freqToKeySet 中 originFre + 1频次不存在插入新记录
            freqToKeySet.put(originFre + 1, new LinkedHashSet<Integer>() {{
                add(key);
            }});
        }
        return ret;
    }

    // 增加 key 对应的 freq
    private void increaseFreq(int key) {

    }

    public void put(int key, int val) {
        if (!keyToNode.containsKey(key)) {
            if (capacity == keyToNode.size()) {
                removeMinFreqKey();
            }
            keyToNode.put(key, new Node(val, 1));
            if (freqToKeySet.containsKey(1)) {
                freqToKeySet.get(1).add(key);
            } else {
                freqToKeySet.put(1, new LinkedHashSet<Integer>() {{
                    add(key);
                }});
            }
            minFreq = 1;
        } else {
            int originFre = keyToNode.get(key).freq;
            keyToNode.put(key, new Node(key, originFre + 1));
            // 最小频次是当前key 且 该频次下只有一条记录，此时才更新
            if (freqToKeySet.get(originFre).size() == 1 && minFreq == originFre) {
                minFreq++;
            }
            freqToKeySet.get(originFre).remove(key);
            if (freqToKeySet.containsKey(originFre + 1)) {
                freqToKeySet.get(originFre + 1).add(key);
            } else {
                freqToKeySet.put(1 + 1, new LinkedHashSet<Integer>() {{
                    add(key);
                }});
            }
        }
    }

    private void removeMinFreqKey() {
        Integer minKey = freqToKeySet.get(minFreq).iterator().next();
        keyToNode.remove(minKey);
        freqToKeySet.get(minFreq).remove(minKey);
    }

    static class Node {
        public Integer data;
        public Integer freq;

        public Node(Integer data, Integer freq) {
            this.data = data;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", freq=" + freq +
                    '}';
        }
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(3);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.put(3, 3);
        lfuCache.put(3, 3);
        lfuCache.put(5, 5);
        lfuCache.keyToNode.forEach((k, v) -> System.out.println(k + "->" + v));
        lfuCache.freqToKeySet.forEach((k, set) -> System.out.println(k + "->" + set.toString()));
    }
}
