package entity;


import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public enum WindowTypeEnum {
    S("秒", ChronoUnit.SECONDS, RiskTime.seconds(1L).toMilliseconds()),
    M("分钟", ChronoUnit.MINUTES, RiskTime.minutes(1L).toMilliseconds()),
    H("小时", ChronoUnit.HOURS, RiskTime.hours(1L).toMilliseconds()),
    D("天", ChronoUnit.DAYS, RiskTime.days(1L).toMilliseconds());

    @Getter
    private String message;
    @Getter
    private ChronoUnit chronoUnit;
    @Getter
    private long time;

    WindowTypeEnum(String message, ChronoUnit chronoUnit, long time) {
        this.message = message;
        this.chronoUnit = chronoUnit;
        this.time = time;
    }

    public static WindowTypeEnum getByName(String name) {
        return Arrays.stream(WindowTypeEnum.values())
                .filter(t -> StringUtils.equalsIgnoreCase(t.name(), name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("根据 '" + name + "' 没有找到时间单位类型"));
    }
}
