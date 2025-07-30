package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class T787857 {
    public static long mergeTimestampAndTime(long dateTimestamp, String timeStr) throws ParseException {
        // 创建日期格式化对象
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai")); // 根据需要设置时区

        // 将日期时间戳转换为日期字符串（不含时间部分）
        String dateStr = dateFormat.format(new Date(dateTimestamp));

        // 合并日期和时间字符串
        String dateTimeStr = dateStr + " " + timeStr;

        // 创建日期时间格式化对象
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dateTimeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai")); // 与上面保持一致

        // 解析为Date对象并获取时间戳
        return dateTimeFormat.parse(dateTimeStr).getTime();
    }

    public static void main(String[] args) {
        try {

            boolean b = "ncsdivsp".startsWith("n");
            // 示例使用
            long dateTimestamp = System.currentTimeMillis(); // 当前时间戳
            String slotTimeFrom = "19:18";

            long mergedTimestamp = mergeTimestampAndTime(Long.parseLong("1751990400000"), slotTimeFrom);

            System.out.println("原始日期时间戳: " + dateTimestamp);
            System.out.println("合并后的时间戳: " + mergedTimestamp);
            System.out.println("格式化显示: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(new Date(mergedTimestamp)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
