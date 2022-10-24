package concurrent;

public class TestVolatile2 {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        final TestVolatile2 test = new TestVolatile2();
        new Thread(() -> {
            test.increase();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(test.inc);
                // test.increase();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        /*while (Thread.activeCount() > 1)  //保证前面的线程都执行完
            Thread.yield();*/
        System.out.println(test.inc);
    }
}