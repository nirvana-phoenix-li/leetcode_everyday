package test;

import org.joda.time.DateTime;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class T8900 {
    public static void main(String[] args) {

        // 创建一个 Calendar 实例
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.FEBRUARY, 27, 10, 0, 0);
        Date firstDate = calendar.getTime();



        // 创建一个 Calendar 实例
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2025, Calendar.FEBRUARY, 28, 11, 0, 0);
        Date SecondDate = calendar2.getTime();

        long between = ChronoUnit.DAYS.between(
                firstDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                SecondDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        System.out.println(between);
    }

}
