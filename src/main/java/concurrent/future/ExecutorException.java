package concurrent.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorException {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute(() -> {
            throw new RuntimeException("asdfasdfasdf");
        });
        executor.shutdown();
    }
}
