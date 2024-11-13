package test;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class T4 {
    public static void main(String[] args) throws ParseException {
        // 定义日期字符串
        Date date = new Date();
        long between = DateUtil.between(date, DateUtil.endOfDay(date), DateUnit.SECOND);
        System.out.println(between);
    }
}
