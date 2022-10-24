package concurrent;

public class TestVolatile {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        final TestVolatile test = new TestVolatile();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++)
                    test.increase();
            }).start();
        }
        Thread.sleep(5000);

        /*while (Thread.activeCount() > 1)  //保证前面的线程都执行完
            Thread.yield();*/
        System.out.println(test.inc);
    }
}