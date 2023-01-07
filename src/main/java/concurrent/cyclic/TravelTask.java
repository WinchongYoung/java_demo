package concurrent.cyclic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 旅行线程
 * Created by jiapeng on 2018/1/7.
 */
public class TravelTask implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private String name;
    private int arriveTime;//赶到的时间

    public TravelTask(CyclicBarrier cyclicBarrier, String name, int arriveTime) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
        this.arriveTime = arriveTime;
    }

    @Override
    public void run() {
        try {
            //模拟达到需要花的时间
            Thread.sleep(arriveTime * 1000L);
            System.out.println(name + "到达集合点");
            cyclicBarrier.await();
            System.out.println(name + "开始旅行啦～～");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}