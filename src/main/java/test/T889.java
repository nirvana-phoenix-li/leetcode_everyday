package test;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.RateLimiter;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T889 {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(3d);
        //注意rateLimiter的qps设置，假设qps为20，那么大概50ms拿到一个令牌桶，如果超时时间设置少于间隔数，
        //则导致大量的请求出现fastfail，设置边界值则有部分fail

        for (int i = 0; i < 1000; i++) {
            rateLimiter.tryAcquire(5000, TimeUnit.MILLISECONDS);
            System.out.println("hhhhhhhhhhhhhhhhhhhhhhhh");
        }

    }
}
