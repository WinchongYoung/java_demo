package concurrent;

import java.util.concurrent.Semaphore;

public class TestSemaphore {

    public static void main(String[] args) {
        // 控制并发数量
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("hahahhha" + Thread.currentThread().getName());
                    Thread.sleep(1000);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
