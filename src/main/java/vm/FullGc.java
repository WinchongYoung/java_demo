package vm;

/**
 * jvm parameters
 * -Xms8m -Xmx8m -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCApplicationConcurrentTime -XX:+PrintHeapAtGC -XX:+PrintTenuringDistribution
 */
public class FullGc {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] b = new byte[size];
        b = null;
        System.gc();
    }
}