package thread;

/**
 * 参考文章：https://www.whywhy.vip/archives/158
 * 不能将Integer作为锁对象，因为当其值变化时，对象也变了
 */
public class TestThread {
    public static void main(String[] args) {
        Thread why = new Thread(new TicketConsumer(10), "why");
        Thread mx = new Thread(new TicketConsumer(10), "mx");
        why.start();
        mx.start();
    }
}
