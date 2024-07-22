package utils;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterUtil {
    public static RateLimiter rateLimiter = RateLimiter.create(150);
}
