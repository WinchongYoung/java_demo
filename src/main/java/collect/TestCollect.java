package collect;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCollect {
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3};
        List<Integer> arrayList = Arrays.asList(integers);
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(arrayList);
        System.out.println(arrayDeque);
        System.out.println(arrayDeque.peekFirst());
        System.out.println(arrayDeque.stream().count());

    }
}
