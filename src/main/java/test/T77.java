package test;


import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class T77 {
    public static void main(String[] args) {
        Date now = new Date();
        // yyyy-MM-dd hh:mm:ss 12小时
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日"); //小写是12小时
        System.out.println(sdf.format(now));

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.addAll(null);
        System.out.println(JSON.toJSONString(integers));


    }
}
