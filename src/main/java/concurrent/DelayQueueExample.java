package concurrent;

import io.reactivex.annotations.NonNull;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedElement> queue = new DelayQueue<>();
        DelayedElement element1 = new DelayedElement(1000);
        DelayedElement element2 = new DelayedElement(0);
        DelayedElement element3 = new DelayedElement(4000);

        queue.put(element1);
        System.out.println("e1放入时间" + System.currentTimeMillis() / 1000);
        DelayedElement e = queue.take();
        System.out.println("e1取出时间:" + System.currentTimeMillis() / 1000);

        queue.put(element2);
        System.out.println("e2放入时间" + System.currentTimeMillis() / 1000);
        DelayedElement e2 = queue.take();
        System.out.println("e2取出时间" + System.currentTimeMillis() / 1000);

        queue.put(element3);
        System.out.println("e3放入时间" + System.currentTimeMillis() / 1000);
        DelayedElement e3 = queue.take();
        System.out.println("e3取出时间" + System.currentTimeMillis() / 1000);
    }
}

class DelayedElement implements Delayed {
    long delayTime;
    long tamp;

    DelayedElement(long delay) {
        delayTime = delay;
        tamp = delay + System.currentTimeMillis();
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