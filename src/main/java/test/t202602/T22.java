package test.t202602;

import java.util.LinkedHashMap;
import java.util.Map;

public class T22 {
    public static void main(String[] args) {
        boolean sss=true;
        String s = sss + "";
        System.out.println(s);

        Map<String, String> params = new LinkedHashMap<>();
        //发送webhook通知
        params.put("预警名称", "同门店相同地址 订单涉及用户数量异常");
        params.put("门店id", "sss");
        params.put("门店名称", "shopName");
        params.put("下单手机号", "shopName");
        params.put("收货手机号", "shopName");
        params.put("订单id", "shopName");
        params.put("订单sku", "shopName");
        params.put("收货地址", "shopName");
        params.put("统计数量", String.valueOf(888));


        StringBuilder contentBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            contentBuilder.append("- **")
                    .append(entry.getKey())
                    .append("**:\t")
                    .append(entry.getValue())
                    .append("\n");
        }
        System.out.println(contentBuilder);
    }
}
