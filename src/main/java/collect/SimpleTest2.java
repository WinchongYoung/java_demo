package collect;

import com.google.common.collect.Lists;

import java.util.List;

public class SimpleTest2 {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("qunar");
        list.add("ctrip");
        list.add("elong");

        /*for (int i = 2; i < list.size(); i--) {
            String item = list.get(i);
            if (item != null && !item.equals("")) {
                list.remove(item);
            }
        }*/

        list.removeIf(next -> next.equals("qunar"));

        list.forEach(System.out::println);
    }
}