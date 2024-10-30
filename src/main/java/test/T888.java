package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import everyday.y2022.august.StockPrice;

public class T888 {
    public static void main(String[] args) {
        String s = "{\"low\":\"0\",\"middle\":\"0\",\"high\":\"F2340675-D85A-4D5F-9341-3B6185E20CC7\"}";
        JSONObject jsonObject = JSON.parseObject(s);
        String string = jsonObject.getString("high");
        boolean contains = "F2340675-D85A-4D5F-9341-3B6185E20CC7".contains("F2340675-D85A-4D5F-9341-3B6185E20CC7");
        System.out.println(contains);
    }
}
