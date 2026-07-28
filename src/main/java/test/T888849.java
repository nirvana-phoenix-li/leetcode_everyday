package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class T888849 {
    public static void main(String[] args) {



        LocalDate timeEnd = LocalDate.now();
        LocalDate timeStart = timeEnd.plusDays(-6);
        long days = ChronoUnit.DAYS.between(timeStart, timeEnd) + 1;
        for (int i = 0; i < days; i++) {
            String dateString = "risk_event_log_index-" + timeStart.plusDays(i).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            System.out.println(dateString);
        }
    }
}
