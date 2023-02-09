package vm;

import algorithm.util.Node;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象在内存的结构
 */
public class TestClassLayout {
    public static void main(String[] args) {
        Node node = new Node();
        List<String> list = new ArrayList<>();
        list.add("hahhahah");
        System.out.println(ClassLayout.parseInstance(list).toPrintable());
    }
}
