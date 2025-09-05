package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class EnhancedRiskLogParser {

    /**
     * 解析完整的风险请求信息
     */
    public static JSONObject parseFullRiskRequest(String log) {
        try {
            // 提取参数部分的JSON
            int paramsStart = log.indexOf("参数:[yhRiskTaskRequest:[YHRiskTaskRequest:");
            if (paramsStart == -1) {
                throw new IllegalArgumentException("参数部分未找到");
            }

            // 找到JSON开始位置
            int jsonStart = log.indexOf("{", paramsStart);
            if (jsonStart == -1) {
                throw new IllegalArgumentException("JSON开始位置未找到");
            }

            // 找到JSON结束位置（需要匹配大括号）
            int braceCount = 0;
            int jsonEnd = -1;

            for (int i = jsonStart; i < log.length(); i++) {
                char c = log.charAt(i);
                if (c == '{') {
                    braceCount++;
                } else if (c == '}') {
                    braceCount--;
                    if (braceCount == 0) {
                        jsonEnd = i + 1; // 包含最后一个}
                        break;
                    }
                }
            }

            if (jsonEnd == -1) {
                throw new IllegalArgumentException("JSON结束位置未找到");
            }

            String outerJsonStr = log.substring(jsonStart, jsonEnd);
            JSONObject outerJson = JSON.parseObject(outerJsonStr);

            // 处理content字段中的转义JSON
            String content = outerJson.getString("content");
            JSONObject contentJson = JSON.parseObject(content);

            // 构建结果
            JSONObject result = new JSONObject();
            result.put("businessType", outerJson.getString("businessType"));
            result.put("resourceType", outerJson.getString("resourceType"));
            result.put("content", contentJson);

            return result;

        } catch (Exception e) {
            throw new RuntimeException("解析完整风险请求失败", e);
        }
    }

    /**
     * 只解析content字段的JSON
     */
    public static JSONObject parseContentOnly(String log) {
        try {
            // 找到content字段的开始位置
            int contentStart = log.indexOf("\"content\":\"");
            if (contentStart == -1) {
                throw new IllegalArgumentException("content字段未找到");
            }

            contentStart += "\"content\":\"".length();

            // 找到content字段的结束位置
            int contentEnd = -1;
            int quoteCount = 0;
            boolean escaped = false;

            for (int i = contentStart; i < log.length(); i++) {
                char c = log.charAt(i);

                if (escaped) {
                    escaped = false;
                    continue;
                }

                if (c == '\\') {
                    escaped = true;
                } else if (c == '"') {
                    quoteCount++;
                    if (quoteCount % 2 == 0) { // 找到配对的引号
                        // 检查后面是否是,"resourceType"
                        if (i + 1 < log.length() && log.startsWith(",\"resourceType", i + 1)) {
                            contentEnd = i;
                            break;
                        }
                    }
                }
            }

            if (contentEnd == -1) {
                throw new IllegalArgumentException("content字段结束位置未找到");
            }

            String escapedJson = log.substring(contentStart, contentEnd);
            // 移除转义字符
            String cleanJson = escapedJson.replace("\\\"", "\"");

            return JSON.parseObject(cleanJson);

        } catch (Exception e) {
            throw new RuntimeException("解析content字段失败", e);
        }
    }

    /**
     * 更简单的方法：使用字符串分割
     */
    public static JSONObject parseContentSimple(String log) {
        try {
            // 使用字符串分割方法
            String[] parts = log.split("\"content\":\"");
            if (parts.length < 2) {
                throw new IllegalArgumentException("content字段未找到");
            }

            String remaining = parts[1];
            String[] endParts = remaining.split("\",\"resourceType\"");
            if (endParts.length < 1) {
                throw new IllegalArgumentException("content字段结束位置未找到");
            }

            String escapedJson = endParts[0];
            // 移除转义字符
            String cleanJson = escapedJson.replace("\\\"", "\"");

            return JSON.parseObject(cleanJson);

        } catch (Exception e) {
            throw new RuntimeException("简单解析content字段失败", e);
        }
    }

    public static void main(String[] args) {
        String input ="{\n" +
        "                    \"_index\": \"yh-eselk710:logstash_runlog_cp-hcfk_risk-center_2025.09.01\",\n" +
        "                    \"_type\": \"_doc\",\n" +
        "                    \"_id\": \"aNicBJkBoF7c1zNXvCTB\",\n" +
        "                    \"_version\": 1,\n" +
        "                    \"_score\": null,\n" +
        "                    \"_source\": {\n" +
        "                        \"host\": {},\n" +
        "                        \"@version\": \"1\",\n" +
        "                        \"ecs\": {},\n" +
        "                        \"level\": \"INFO\",\n" +
        "                        \"tags\": [\n" +
        "                            \"_grokparsefailure\"\n" +
        "                        ],\n" +
        "                        \"type\": \"runlog\",\n" +
        "                        \"log\": {\n" +
        "                            \"offset\": 30276685,\n" +
        "                            \"file\": {\n" +
        "                                \"path\": \"/data/log/operation/cp-hcfk/risk-center/2684217-2025.8.28-173849-master/k8s_risk-center-2e61d-59bd567b9d-58rxv_fk-prod_10.215.86.150_10.226.111.53/run.log\"\n" +
        "                            }\n" +
        "                        },\n" +
        "                        \"git_tag\": \"2684217-2025.8.28-173849-master\",\n" +
        "                        \"datetime\": \"2025-09-01 17:10:08,632\",\n" +
        "                        \"content\": \"[TID: 968b2066f9b940c69c0a811a134acdc9.505774.17567178084537827] 进入风控V2.0,方法名:[YHRiskTaskServiceImpl.fetchRiskLevelV2(..)]调用结束,消耗[97ms],返回值:[YhResponse:{\\\"code\\\":200000,\\\"ok\\\":true,\\\"result\\\":{\\\"riskCode\\\":10000,\\\"riskLevel\\\":0,\\\"riskMsg\\\":\\\"中低风险\\\"}}] @@@ 参数:[yhRiskTaskRequest:[YHRiskTaskRequest:{\\\"businessType\\\":\\\"7\\\",\\\"content\\\":\\\"{\\\\\\\"couponCode\\\\\\\":\\\\\\\"000010055260947\\\\\\\",\\\\\\\"deliveryMode\\\\\\\":1,\\\\\\\"deviceId\\\\\\\":\\\\\\\"9e3a9a5f-8a32-4593-b0f5-feb29b5bddf0\\\\\\\",\\\\\\\"ip\\\\\\\":\\\\\\\"180.233.91.32\\\\\\\",\\\\\\\"isBalancePay\\\\\\\":false,\\\\\\\"latitude\\\\\\\":\\\\\\\"25.85557710484934\\\\\\\",\\\\\\\"longitude\\\\\\\":\\\\\\\"118.94193892660176\\\\\\\",\\\\\\\"memberId\\\\\\\":\\\\\\\"879224215239483192\\\\\\\",\\\\\\\"mobile\\\\\\\":\\\\\\\"13960707831\\\\\\\",\\\\\\\"mobileType\\\\\\\":\\\\\\\"CDY-AN90\\\\\\\",\\\\\\\"orderAt\\\\\\\":\\\\\\\"2025-09-01 17:10:08\\\\\\\",\\\\\\\"orderId\\\\\\\":1206931190015087,\\\\\\\"orderRemark\\\\\\\":\\\\\\\"联系不上放家门口\\\\\\\",\\\\\\\"orderTags\\\\\\\":[\\\\\\\"epr\\\\\\\"],\\\\\\\"os\\\\\\\":\\\\\\\"android\\\\\\\",\\\\\\\"osVersion\\\\\\\":\\\\\\\"Android 10\\\\\\\",\\\\\\\"platform\\\\\\\":\\\\\\\"wechatminiprogram\\\\\\\",\\\\\\\"promotionCode\\\\\\\":\\\\\\\"8Q49\\\\\\\",\\\\\\\"promotionInfoList\\\\\\\":[{\\\\\\\"couponCode\\\\\\\":\\\\\\\"000010055260947\\\\\\\",\\\\\\\"promoType\\\\\\\":\\\\\\\"OrderCoupon\\\\\\\",\\\\\\\"promotionCode\\\\\\\":\\\\\\\"8Q49\\\\\\\"}],\\\\\\\"receiverAddr\\\\\\\":\\\\\\\"2号楼1624单元\\\\\\\",\\\\\\\"receiverArea\\\\\\\":\\\\\\\"万冠双子星\\\\\\\",\\\\\\\"receiverCity\\\\\\\":\\\\\\\"福州\\\\\\\",\\\\\\\"receiverName\\\\\\\":\\\\\\\"鄢|M\\\\\\\",\\\\\\\"receiverPhone\\\\\\\":\\\\\\\"13960707831\\\\\\\",\\\\\\\"salesBusinessType\\\\\\\":1,\\\\\\\"salesChannel\\\\\\\":202,\\\\\\\"sessionId\\\\\\\":\\\\\\\"c6437b11-cb76-4988-a6fa-df848f1777ba\\\\\\\",\\\\\\\"shopId\\\\\\\":\\\\\\\"9MBB\\\\\\\",\\\\\\\"skuCodes\\\\\\\":[\\\\\\\"1719589\\\\\\\",\\\\\\\"278764\\\\\\\",\\\\\\\"2043575\\\\\\\",\\\\\\\"457466\\\\\\\",\\\\\\\"1568666\\\\\\\",null],\\\\\\\"skuDetailInfoList\\\\\\\":[{\\\\\\\"bomType\\\\\\\":1,\\\\\\\"categoryCode\\\\\\\":\\\\\\\"11400114\\\\\\\",\\\\\\\"exclusiveForNewcomers\\\\\\\":false,\\\\\\\"expiration\\\\\\\":1,\\\\\\\"goodsCount\\\\\\\":1,\\\\\\\"goodsFlag\\\\\\\":\\\\\\\"normal\\\\\\\",\\\\\\\"skuCode\\\\\\\":\\\\\\\"1719589\\\\\\\",\\\\\\\"skuCodeWithPrefix\\\\\\\":\\\\\\\"R-1719589\\\\\\\"},{\\\\\\\"bomType\\\\\\\":1,\\\\\\\"categoryCode\\\\\\\":\\\\\\\"12300301\\\\\\\",\\\\\\\"exclusiveForNewcomers\\\\\\\":false,\\\\\\\"expiration\\\\\\\":1,\\\\\\\"goodsCount\\\\\\\":1,\\\\\\\"goodsFlag\\\\\\\":\\\\\\\"normal\\\\\\\",\\\\\\\"skuCode\\\\\\\":\\\\\\\"278764\\\\\\\",\\\\\\\"skuCodeWithPrefix\\\\\\\":\\\\\\\"R-278764\\\\\\\"},{\\\\\\\"bomType\\\\\\\":1,\\\\\\\"categoryCode\\\\\\\":\\\\\\\"11600201\\\\\\\",\\\\\\\"exclusiveForNewcomers\\\\\\\":false,\\\\\\\"expiration\\\\\\\":1,\\\\\\\"goodsCount\\\\\\\":1,\\\\\\\"goodsFlag\\\\\\\":\\\\\\\"normal\\\\\\\",\\\\\\\"skuCode\\\\\\\":\\\\\\\"2043575\\\\\\\",\\\\\\\"skuCodeWithPrefix\\\\\\\":\\\\\\\"R-2043575\\\\\\\"},{\\\\\\\"bomType\\\\\\\":1,\\\\\\\"categoryCode\\\\\\\":\\\\\\\"12530103\\\\\\\",\\\\\\\"exclusiveForNewcomers\\\\\\\":false,\\\\\\\"expiration\\\\\\\":1,\\\\\\\"goodsCount\\\\\\\":1,\\\\\\\"goodsFlag\\\\\\\":\\\\\\\"normal\\\\\\\",\\\\\\\"skuCode\\\\\\\":\\\\\\\"457466\\\\\\\",\\\\\\\"skuCodeWithPrefix\\\\\\\":\\\\\\\"R-457466\\\\\\\"},{\\\\\\\"bomType\\\\\\\":2,\\\\\\\"categoryCode\\\\\\\":\\\\\\\"11090204\\\\\\\",\\\\\\\"exclusiveForNewcomers\\\\\\\":false,\\\\\\\"expiration\\\\\\\":8,\\\\\\\"goodsCount\\\\\\\":1,\\\\\\\"goodsFlag\\\\\\\":\\\\\\\"normal\\\\\\\",\\\\\\\"skuCode\\\\\\\":\\\\\\\"1568666\\\\\\\",\\\\\\\"skuCodeWithPrefix\\\\\\\":\\\\\\\"R-CBS1568666-RE1\\\\\\\"},{\\\\\\\"bomType\\\\\\\":2,\\\\\\\"categoryCode\\\\\\\":\\\\\\\"11430201\\\\\\\",\\\\\\\"exclusiveForNewcomers\\\\\\\":false,\\\\\\\"expiration\\\\\\\":1,\\\\\\\"goodsCount\\\\\\\":1,\\\\\\\"goodsFlag\\\\\\\":\\\\\\\"order.gift\\\\\\\",\\\\\\\"skuCodeWithPrefix\\\\\\\":\\\\\\\"R-CB208381065\\\\\\\"}],\\\\\\\"timeSlotDate\\\\\\\":1756656000000,\\\\\\\"version\\\\\\\":\\\\\\\"11.8.5.13\\\\\\\"}\\\",\\\"resourceType\\\":\\\"order\\\"}]]\",\n" +
        "                        \"agent\": {},\n" +
        "                        \"@timestamp\": \"2025-09-01T09:10:08.632Z\",\n" +
        "                        \"threadinfo\": \" [DubboServerHandler-10.226.111.53:30190-thread-175]\",\n" +
        "                        \"fields\": {\n" +
        "                            \"tag\": \"shanghai-idc\",\n" +
        "                            \"document_type\": \"runlog-cp-hcfk\"\n" +
        "                        },\n" +
        "                        \"input\": {},\n" +
        "                        \"k8s_pod\": \"risk-center-2e61d-59bd567b9d-58rxv\",\n" +
        "                        \"org\": \"operation\",\n" +
        "                        \"pod_ip\": \"10.226.111.53\",\n" +
        "                        \"application_name\": \"risk-center\",\n" +
        "                        \"project_name\": \"cp-hcfk\",\n" +
        "                        \"function\": \"com.yonghui.risk.utils.log.MethodAroundLogInterceptor\",\n" +
        "                        \"ns\": \"fk-prod\",\n" +
        "                        \"node_ip\": \"10.215.86.150\"\n" +
        "                    },\n" +
        "                    \"fields\": {\n" +
        "                        \"@timestamp\": [\n" +
        "                            \"2025-09-01T09:10:08.632Z\"\n" +
        "                        ]\n" +
        "                    },\n" +
        "                    \"sort\": [\n" +
        "                        1756717808632\n" +
        "                    ]\n" +
        "                }";
        try {
//            System.out.println("=== 完整解析结果 ===");
//            JSONObject fullResult = parseFullRiskRequest(input);
//            System.out.println(JSON.toJSONString(fullResult, SerializerFeature.PrettyFormat));

//            System.out.println("\n" + "=".repeat(50) + "\n");

//            System.out.println("=== 只解析content结果 ===");
//            JSONObject contentOnly = parseContentOnly(input);
//            System.out.println(JSON.toJSONString(contentOnly, SerializerFeature.PrettyFormat));

//            System.out.println("\n" + "=".repeat(50) + "\n");

            System.out.println("=== 简单方法解析content ===");
            JSONObject contentSimple = parseContentSimple(input);
            System.out.println(JSON.toJSONString(contentSimple, SerializerFeature.PrettyFormat));

        } catch (Exception e) {
            System.out.println("解析失败: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
