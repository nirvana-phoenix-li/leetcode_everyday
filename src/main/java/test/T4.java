package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class T4 {
    public static void main(String[] args) throws ParseException {
        // 定义日期字符串
        String dateString = "2024-09-18 15:30:45";

        // 定义日期格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 将字符串解析为 java.util.Date
//        Date date = formatter.parse(dateString);
        Date date = new Date();

        // 输出结果
        System.out.println("String: " + dateString);
        System.out.println("Date: " + date);
    }
}
