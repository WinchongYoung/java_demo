package test.common;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayCopyThreadSafe {
    private static final int[] arrayOriginal = new int[1024 * 1024 * 10];
    private static final int[] arraySrc = new int[1024 * 1024 * 10];
    private static final int[] arrayDist = new int[1024 * 1024 * 10];
    private static final ReentrantLock lock = new ReentrantLock();

    private static void modify() {
        for (int i = 0; i < arraySrc.length; i++) {
            arraySrc[i] = i + 1;
        }
    }

    private static void copy() {
        System.arraycopy(arraySrc, 0, arrayDist, 0, arraySrc.length);
    }

    private static void init() {
        for (int i = 0; i < arraySrc.length; i++) {
            arrayOriginal[i] = i;
            arraySrc[i] = i;
            arrayDist[i] = 0;
        }
    }

    private static void doThreadSafeCheck() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("run count: " + (i + 1));
            init();
            Condition condition = lock.newCondition();

            new Thread(() -> {
                lock.lock();
                condition.signalAll();
                lock.unlock();
                copy();
            }).start();

            lock.lock();
            // 这里使用 Condition 来保证拷贝线程先已经运行了.
            condition.await();
            lock.unlock();

            Thread.sleep(2); // 休眠2毫秒, 确保拷贝操作已经执行了, 才执行修改操作.
            modify();

            if (!Arrays.equals(arrayOriginal, arrayDist)) {
                throw new RuntimeException("System.arraycopy is not thread safe");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        doThreadSafeCheck();
    }
}