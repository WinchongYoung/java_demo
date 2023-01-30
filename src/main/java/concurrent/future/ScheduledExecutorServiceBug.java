package concurrent.future;

import net.openhft.affinity.AffinityLock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 参考文章：https://juejin.cn/post/7189104246728425531
 */
public class ScheduledExecutorServiceBug {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(100);
        //绑定到5号CPU上执行
        try (AffinityLock affinityLock = AffinityLock.acquireLock(5)) {
            for (;;) {
                try {
                    Runnable r = workQueue.poll(0, TimeUnit.NANOSECONDS);
                    if (r != null)
                        break;
                } catch (InterruptedException retry) {
                }
            }
        }
    }
}
