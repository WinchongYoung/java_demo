package concurrent.queue;

import io.netty.util.HashedWheelTimer;
import io.reactivex.annotations.NonNull;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedElement> queue = new DelayQueue<>();
        DelayedElement element1 = new DelayedElement(1000, "element1");
        DelayedElement element2 = new DelayedElement(0, "element2");
        DelayedElement element3 = new DelayedElement(4000, "element3");

        queue.put(element1);
        queue.put(element2);
        queue.put(element3);

        DelayedElement e = queue.take();
        System.out.println("取出元素" + e.name + "取出时间:" + System.currentTimeMillis() / 1000);

        DelayedElement e2 = queue.take();
        System.out.println("取出元素" + e2.name + "取出时间:" + System.currentTimeMillis() / 1000);

        DelayedElement e3 = queue.take();
        System.out.println("取出元素" + e3.name + "取出时间:" + System.currentTimeMillis() / 1000);

    }
}

class DelayedElement implements Delayed {
    long delayTime;
    long tamp;
    String name;

    DelayedElement(long delay, String name) {
        delayTime = delay;
        tamp = delay + System.currentTimeMillis();
        this.name = name;
    }

    @Override
    public long getDelay(@NonNull TimeUnit unit) {
        return tamp - System.currentTimeMillis();
    }

    @Override
    public int compareTo(@NonNull Delayed o) {
        return tamp - ((DelayedElement) o).tamp > 0 ? 1 : -1;
    }
}