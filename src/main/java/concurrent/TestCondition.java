package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestCondition {

    private volatile boolean isBeforeDo = false;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void before() {
        lock.lock();
        try {
            System.out.println("fire");
            condition.signalAll();
        } finally {
            isBeforeDo = true;
            lock.unlock();
        }
    }

    public void after() {
        lock.lock();
        try {
            while (!isBeforeDo) {
                condition.await();
            }
            System.out.println("cook");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        TestCondition example = new TestCondition();
        executorService.execute(example::after);
        executorService.execute(example::before);
        executorService.shutdown();
    }

}
