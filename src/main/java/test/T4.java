package test;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class T4 {
    public static void main(String[] args) throws ParseException {
        String original = "{\"id\": 83,\"recordId\": 2982,\"memberId\": 215995502578101273,\"type\": \"expire_remind_more\"}";
        String s = original.replaceAll(" ", "");
        System.out.println(s);


    }
}
