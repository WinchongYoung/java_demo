package concurrent.future;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.concurrent.*;

/**
 * 多线程调用接口示例代码
 */
public class BatchApiWithFuture {
    public static void main(String[] args) {
        List<Long> ids = new ArrayList<Long>() {
        };
        for (int i = 0; i < 500; i++) {
            ids.add(i + 1L);
        }
        int pageSize = ids.size() > 8 ? ids.size() >> 3 : 1;
        List<List<Long>> partitionIdList = Lists.partition(ids, pageSize);
        List<CompletableFuture<?>> futures = new ArrayList<>();
        // 如果ids为500，这里会分隔成9份，也就是partitionIdList.size()=9；
        // 遍历9次,也相当于创建了9个CompletableFuture对象，前8个CompletableFuture对象处理62个数据。第9个处理4个数据。
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(9, 9, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        partitionIdList.forEach(partitionIds -> {
            CompletableFuture<Map<Long, String>> future = CompletableFuture.supplyAsync(() -> getBasicData(partitionIds), threadPoolExecutor);
            futures.add(future);
        });
        // 把所有线程执行的结果进行汇总
        Map<Long, String> map = new HashMap<>();
        for (CompletableFuture<?> future : futures) {
            try {
                Map<Long, String> result = (Map<Long, String>) future.get();
                result.forEach((k, v) -> map.put(k, v));
                result.forEach((k, v) -> System.out.println(k + "->" + v));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        threadPoolExecutor.shutdown();
    }

    public static Map<Long, String> getBasicData(List<Long> ids) {
        Map<Long, String> map = new HashMap<>();
        ids.forEach(id -> map.put(id, "++" + id + "++"));
        int random = new Random().nextInt(1000000);
        for (int i = 0; i < random; i++) {
            System.out.print("");
        }
        return map;
    }
}
