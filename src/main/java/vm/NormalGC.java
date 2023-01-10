package vm;

/**
 * jvm parameters
 * -Xms8m -Xmx8m -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCApplicationConcurrentTime -XX:+PrintHeapAtGC -XX:+PrintTenuringDistribution
 */
public class NormalGC {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        for (int i = 0; ; i++) {
            Thread.sleep(1000);
            byte[] b = new byte[1024 * 1024];
            b = null;
        }
    }
}