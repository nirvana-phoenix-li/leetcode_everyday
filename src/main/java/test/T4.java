package test;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.*;

public class T4 {
    public static void main(String[] args) throws ParseException {

        String text = "{\"skuDetailInfoList\":[{\"goodsCount\":1,\"exclusiveForNewcomers\":false,\"expiration\":1,\"goodsFlag\":\"normal\",\"skuCodeWithPrefix\":\"B-955124\",\"bomType\":1,\"skuCode\":\"955124\"},{\"goodsCount\":2,\"exclusiveForNewcomers\":false,\"expiration\":1,\"goodsFlag\":\"normal\",\"skuCodeWithPrefix\":\"B-CB2159451\",\"bomType\":2}]}";
        JSONObject jsonObject = JSONObject.parseObject(text);
        List<Object> skuDetailInfoList = (List<Object>) jsonObject.get("skuDetailInfoList");
        TreeSet<String> skuAndCount = new TreeSet<>();
        for (Object skuDetail : skuDetailInfoList) {
            StringBuilder sb = new StringBuilder();
            String skuCodeWithPrefix = String.valueOf(((Map) skuDetail).get("skuCodeWithPrefix"));
            String goodsCount = String.valueOf(((Map) skuDetail).get("goodsCount"));
            sb.append(skuCodeWithPrefix).append("_").append(goodsCount).append(",");
            skuAndCount.add(sb.toString());
        }

        if (CollectionUtils.isEmpty(skuAndCount)){
            System.out.println("0000000");
        }
        System.out.println(String.join("", skuAndCount));
    }
}
