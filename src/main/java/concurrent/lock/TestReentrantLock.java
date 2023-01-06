package concurrent.lock;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {

    int i = 0;
    ReentrantLock lock = new ReentrantLock(true);

    public void add() {
        lock.lock();
        try {
            i++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestReentrantLock testReentrantLock = new TestReentrantLock();
        new Thread(testReentrantLock::add).start();
        new Thread(testReentrantLock::add).start();
        Thread.sleep(1000);
        System.out.println(testReentrantLock.i);

        Map<String, String> map = new Hashtable<>();
    }
}
