package entity;

import java.util.concurrent.TimeUnit;

public class RiskTime {
    private final TimeUnit unit;
    private final long size;

    private RiskTime(long size, TimeUnit unit) {
        this.unit = unit;
        this.size = size;
    }

    public TimeUnit getUnit() {
        return this.unit;
    }

    public long getSize() {
        return this.size;
    }

    public long toMilliseconds() {
        return this.unit.toMillis(this.size);
    }

    public static RiskTime of(long size, TimeUnit unit) {
        return new RiskTime(size, unit);
    }

    public static RiskTime milliseconds(long milliseconds) {
        return of(milliseconds, TimeUnit.MILLISECONDS);
    }

    public static RiskTime seconds(long seconds) {
        return of(seconds, TimeUnit.SECONDS);
    }

    public static RiskTime minutes(long minutes) {
        return of(minutes, TimeUnit.MINUTES);
    }

    public static RiskTime hours(long hours) {
        return of(hours, TimeUnit.HOURS);
    }

    public static RiskTime days(long days) {
        return of(days, TimeUnit.DAYS);
    }
}
