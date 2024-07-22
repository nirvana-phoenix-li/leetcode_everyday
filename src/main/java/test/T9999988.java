package test;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

public class T9999988 {
    public static void main(String[] args) {
        // 创建一个每秒允许150个许可的RateLimiter
        long currentTimeMillis = System.currentTimeMillis();
        RateLimiter rateLimiter = RateLimiter.create(20.0);

        for (int i = 0; i < 1000; i++) {
            // 从限流器中获取一个许可
//            rateLimiter.tryAcquire(20, TimeUnit.MILLISECONDS);
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
