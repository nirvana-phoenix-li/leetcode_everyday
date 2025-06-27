package entity;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

public class DateTimeUtils {

    /**
     * 默认的日期格式
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 年月日格式
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    /**
     * 年月日
     */
    public static final String FORMAT_DEFAULT_YEAR_MONTH_DAY_1 = "yyyy.MM.dd";

    /**
     * 年月日
     */
    public static final String FORMAT_DEFAULT_YEAR_MONTH_DAY_2 = "yyyyMMdd";
    /**
     * localDateTime的默认格式
     */
    public static final String LOCAL_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";


    public static Boolean isFirstSmallerThanSecondInCompareDays(Date first, Date second, int compareDays) {
        if (first == null) {
            return false;
        }
        if (second == null) {
            return false;
        }
        int diffDays = getDaysDiff(first, second);
        if (diffDays < compareDays) {
            return true;
        } else {
            return false;
        }
    }

    public static int getDaysDiff(Date date1, Date date2) {
        DateTime time1 = new DateTime(date1).withTime(0, 0, 0, 0);
        DateTime time2 = new DateTime(date2).withTime(0, 0, 0, 0);
        long days_diff = (time2.getMillis() - time1.getMillis()) / (1000 * 3600 * 24);

        return new Long(days_diff).intValue();
    }

    /**
     * 计算两个日期间的天数
     *
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return
     */
    public static long getSpanDays(Date startDate, Date endDate) {
        if (null == startDate || endDate == null) {
            return 0;
        }
        return Duration.between(startDate.toInstant(), endDate.toInstant()).toDays();
    }

    /**
     * 获取当前日期的字符串格式
     *
     * @param dateFormat
     * @return
     */
    public static String getCurrentDate(String dateFormat) {
        if (StringUtils.isBlank(dateFormat)) {
            dateFormat = DEFAULT_DATE_FORMAT;
        }
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern(dateFormat));
    }

    /**
     * 格式化日期
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static String formatDate(Date date, String dateFormat) {
        if (StringUtils.isBlank(dateFormat)) {
            dateFormat = DEFAULT_DATE_FORMAT;
        }
        if (date == null) {
            date = new Date();
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        return localDateTime.format(DateTimeFormatter.ofPattern(dateFormat));
    }

    /**
     * 格式化日期
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static Date parseDateString(String date, String dateFormat) {
        if (StringUtils.isBlank(dateFormat)) {
            dateFormat = DEFAULT_DATE_FORMAT;
        }
        if (StringUtils.isBlank(date)) {
            return new Date();
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
        LocalDateTime localDateTime = LocalDateTime.parse(date, dtf);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取指定XX小时前的日期
     *
     * @param beforeNowHours
     * @return
     */
    public static Date getDateBeforeHours(int beforeNowHours) {
        Instant instant = Instant.now().minus(Duration.ofHours(beforeNowHours));
        return Date.from(instant);
    }

    public static Date parseDateLong(long time){
        Instant instant = Instant.ofEpochMilli(time);
        return Date.from(instant);
    }

    public static Date getSomeDateBefore(int beforeNumber, ChronoUnit chronoUnit) {
        if (null == chronoUnit) {
        }
        Instant instant = Instant.now().atOffset(ZoneOffset.UTC).minus(beforeNumber, chronoUnit).toInstant();
        return Date.from(instant);
    }

    /**
     *
     * @param pattern 时间格式 yyyy-MM-dd HH:mm:ss
     * @return 格式化后的时间
     */
    public static String getDateTimeFormat(String pattern){
        if(StringUtils.isBlank(pattern)){
            pattern=DEFAULT_DATE_FORMAT;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(LocalDateTime.now());
    }

    /**
     *
     * @param  dateTime yyyy-MM-dd HH:mm:ss
     * @return 格式化后的时间
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        return Optional.ofNullable(dateTime).map(localDateTime -> localDateTime.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT))).orElse("");
    }

    /**
     * 格式化日期
     *
     * @param time
     * @param pattern
     * @return
     */
    public static String dateFormatShZone(long time, String pattern) {
        TimeZone pst = TimeZone.getTimeZone("Asia/Shanghai");
        DateFormat dateFormatter = new SimpleDateFormat(pattern);
        dateFormatter.setTimeZone(pst);
        return dateFormatter.format(new Date(time));
    }

    public static String timeToString(Long time){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
        return dateTimeFormatter.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time),ZoneId.systemDefault()));
    }

    public static String getPlusDaysByFormat(long days){
        return LocalDateTime.now().plusDays(days).format(DateTimeFormatter.ofPattern(FORMAT_DEFAULT_YEAR_MONTH_DAY_2));
    }

    /**
     * String时间类型相差天数计算
     * 如果sdtStart<sdtEnd 结果为正值，否为负值
     */
    public static long getSpanDays(String sdtStart, String sdtEnd, String dateFormat) {
        if (StringUtils.isBlank(sdtStart) || StringUtils.isBlank(sdtEnd)) {
            return 0;
        }
        if (StringUtils.isBlank(dateFormat)) {
            dateFormat = FORMAT_DEFAULT_YEAR_MONTH_DAY_2;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
        LocalDate dateStart = LocalDate.parse(sdtStart, dateTimeFormatter);
        LocalDate dateEnd = LocalDate.parse(sdtEnd, dateTimeFormatter);
        return dateStart.until(dateEnd, ChronoUnit.DAYS);
    }

    public static Date transFromLocalDateTime(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return null;
        }
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * date转换成localdatetime
     *
     * @param date
     * @return
     */
    public static LocalDateTime transFromDate(Date date) {
        if (null == date) {
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }
}
