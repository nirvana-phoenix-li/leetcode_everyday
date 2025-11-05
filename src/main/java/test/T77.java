package test;


import java.text.SimpleDateFormat;
import java.util.Date;

public class T77 {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

// 格式化为字符串
        String dateString = sdf.format(date);
        System.out.println(dateString); // 输出：2023-10-25 14:30:45
    }

}
