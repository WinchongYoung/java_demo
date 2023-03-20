package collect;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

public class SimpleTest {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        //正例
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("1".equalsIgnoreCase(item)) {
                iterator.remove();
            }
        }

        //反例
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            if ("1".equalsIgnoreCase(item)) {
                iterator.remove();
            }
        }
    }
}