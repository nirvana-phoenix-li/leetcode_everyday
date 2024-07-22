package test.importantTest;

import com.google.common.util.concurrent.RateLimiter;
import utils.RateLimiterUtil;

import java.util.concurrent.TimeUnit;

public class RateLimiterTest {

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = RateLimiterUtil.rateLimiter;
        Thread.sleep(1000);

        // 创建一个每秒允许150个许可的RateLimiter
        long currentTimeMillis = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            // 从限流器中获取一个许可
            boolean b = rateLimiter.tryAcquire(20, TimeUnit.MILLISECONDS);
            System.out.println(b);

            rateLimiter.acquire();

            // 执行某些操作
            doSomething(i);
        }
        System.out.println("use time----------------" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public static void doSomething(int i) {
        System.out.println("Action " + i);
    }
}
