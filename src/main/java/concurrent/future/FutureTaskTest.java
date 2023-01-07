package concurrent.future;

import java.util.concurrent.*;

public class FutureTaskTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            Integer sum = 0;
            for (int i = 0; i < 100000; i++) {
                sum += i;
            }
            return sum;
        });
        executorService.submit(futureTask);

        FutureTask<Integer> futureTask2 = new FutureTask<>(() -> {
            Integer sum = 0;
            for (int i = 100001; i < 200000; i++) {
                sum += i;
            }
            return sum;
        });
        executorService.submit(futureTask2);

        System.out.println(futureTask.get() + futureTask.get());

        executorService.shutdown();
        Thread.sleep(500);
    }
}
