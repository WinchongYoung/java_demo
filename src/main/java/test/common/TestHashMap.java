package test.common;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
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
