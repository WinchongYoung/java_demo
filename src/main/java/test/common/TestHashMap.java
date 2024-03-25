package test.common;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "2");
        map.put(4, "2");
        map.put(5, "2");
        map.put(6, "2");
        map.put(7, "2");
        map.put(8, "2");
        map.put(9, "1-1");
        map.put(10, "1-1");
        map.put(101, "1-1");
    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
