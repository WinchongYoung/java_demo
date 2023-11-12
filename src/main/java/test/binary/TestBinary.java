package test.binary;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class TestBinary {

    public static void main(String[] args) {
        splitIntToIntArr(127).forEach(System.out::println);

        ArrayList<Integer> arrayList = Lists.newArrayList(1, 2, 4, 8);
        Integer integer = combineInts2Single(arrayList);
        System.out.println(integer);
    }

    /**
     * spit a int to a int list
     **/
    public static List<Integer> splitIntToIntArr(int n) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                list.add(1 << i);
            }
            i++;
            n = n >> 1;
        }
        return list;
    }

    public static Integer combineInts2Single(List<Integer> l) {
        int result = 0;
        for (Integer i : l) {
            result = result | i;
        }
        return result;
    }
}
