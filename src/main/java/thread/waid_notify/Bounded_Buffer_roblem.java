package thread.waid_notify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//生产者消费者问题
public class Bounded_Buffer_roblem {

    public static void main(String[] args) {
        Food food = new Food(3);
        ExecutorService pro_executor = Executors.newCachedThreadPool(); //消费者线程池
        ExecutorService con_executor = Executors.newCachedThreadPool(); //生产者线程池

        for (int i = 0; i < 10; i++) {
            pro_executor.execute(new producer(food));
            con_executor.execute(new consumer(food));
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        con_executor.shutdown();
        pro_executor.shutdown();
    }
}