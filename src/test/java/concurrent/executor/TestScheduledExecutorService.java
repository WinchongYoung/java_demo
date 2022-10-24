package concurrent.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 参考文档
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1306581130018849
 */
public class TestScheduledExecutorService {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
        ses.scheduleAtFixedRate(() -> {
            System.out.println("Haha");
            // 2秒后开始执行定时任务，每3秒执行:
        }, 2, 3, TimeUnit.SECONDS);

        ses.scheduleWithFixedDelay(() -> {
            System.out.println("Gaga");
            // 2秒后开始执行定时任务，执行完后等待3秒再执行
        }, 2, 3, TimeUnit.SECONDS);
    }
}