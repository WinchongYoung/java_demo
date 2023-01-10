package vm;

import java.util.Vector;

/**
 * jvm parameters
 * -Xms8m -Xmx8m -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCApplicationConcurrentTime -XX:+PrintHeapAtGC -XX:+PrintTenuringDistribution
 */
public class Leak2GC {
    public static void main(String[] args) {
        Vector strings = new Vector();

        for (int i = 0; ; i++) {
            String str = "Hello gc" + i;
            strings.add(str);
            str = null;
        }
    }
}