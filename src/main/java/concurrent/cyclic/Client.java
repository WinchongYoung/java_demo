package concurrent.cyclic;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier:让一组线程到达一个屏障(同步点)时被阻塞，直到这组线程中的最后一个到达屏障时(调用await方法)，屏障才会打开
 * <p>
 * CyclicBarrier和CountDownLatch的区别:
 * 1、首先二者都能让一个或多个线程阻塞等待，都可以用在多个线程间的协调，起到线程同步的作用。
 * 但CountDownLatch是多个线程都进行了countDown之后才会触发时间，唤醒await在latch上
 * 的线程，执行完countDown操作之后会继续自己线程的工作。而CyclicBarrier是一个栅栏，
 * 用于同步所有调用await方法的线程，等到所有的方法都执行了await方法后，所有的线程才会
 * 返回各自执行自己的工作。
 * 2、CountDownLatch计数器只能使用一次，而CyclicBarrier的计数器可以调用 reset()
 * 方法重置，能处理更加复杂的业务场景。
 */
public class Client {
    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new TourGuideTask());
        ExecutorService executor = Executors.newFixedThreadPool(3);
        //登哥最大牌，到的最晚
        executor.execute(new TravelTask(cyclicBarrier, "哈登", 5));
        executor.execute(new TravelTask(cyclicBarrier, "保罗", 3));
        executor.execute(new TravelTask(cyclicBarrier, "戈登", 1));

        Thread.sleep(10 * 1000L);
        executor.shutdownNow();
    }
}