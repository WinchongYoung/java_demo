package thread;

import com.google.common.collect.Lists;

import java.util.concurrent.CopyOnWriteArrayList;

class Test {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = Lists.newCopyOnWriteArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add(0, "E");

        // arraycopy
        // arraycopy(Object src,  int  srcPos, Object dest, int destPos, int length);
    }

}
