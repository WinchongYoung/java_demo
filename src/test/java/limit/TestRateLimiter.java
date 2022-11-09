package limit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 令牌限流测试
 * 1、RateLimiter.create(5)表示桶容量为5且每秒新增5个令牌，即每隔200毫秒新增一个令牌；
 * 2、limiter.acquire()表示消费一个令牌，如果当前桶中有足够令牌则成功（返回值为0），
 * 如果桶中没有令牌则暂停一段时间，比如发令牌间隔是200毫秒，则等待200毫秒后再去消费令牌
 * （如上测试用例返回的为0.198239，差不多等待了200毫秒桶中才有令牌可用），
 * 这种实现将突发请求速率平均为了固定请求速率。如果结构不想等待可以采用tryAcquire立刻返回
 */
public class TestRateLimiter {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = RateLimiter.create(100);
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
    }
}
