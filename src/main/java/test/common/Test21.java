package test.common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * test Map.computeIfAbsent
 */
public class Test21 {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1000, "A");
        map.putIfAbsent(2000, "B");
        map.computeIfAbsent(3000, x -> x + "HaHa");
        map.forEach((x, y) -> System.out.println(x + "->" + y));

        System.out.println("开始执行");
        ConcurrentHashMap<String, Integer> currMap = new ConcurrentHashMap<>();
        currMap.computeIfAbsent("AaAa", key -> currMap.computeIfAbsent("BBBB", key2 -> 42));
        System.out.println("结束执行");
    }

}
