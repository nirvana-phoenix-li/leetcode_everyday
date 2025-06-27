package entity;

public class TimePair {
    private long startTime;
    private long endTime;

    private TimePair(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String toString() {
        return "TimePair{startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
    }

    /**
     * 5D，1H等
     * @param timeSpan 5
     * @param timeUnit D
     * @param eventTime 当前时间
     * @param earlyTime 最早开始时间
     * @return
     */
    public static TimePair build(int timeSpan, WindowTypeEnum timeUnit, Long eventTime, Long earlyTime) {
        long current = eventTime == null ? System.currentTimeMillis() : eventTime;
        if (earlyTime != null) {
            return new TimePair(earlyTime, current);
        }
        long window = timeUnit.getTime();
        return new TimePair(current - (long) timeSpan * window, current);
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }
}
