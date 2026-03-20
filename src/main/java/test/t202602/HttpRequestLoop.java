package test.t202602;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * HTTP请求循环工具类
 * 用于批量调用 risk-hub 接口绑定业务字段
 */
public class HttpRequestLoop {

    // 请求地址
    private static final String REQUEST_URL = "https://hc.yonghuivip.com/app/api/risk-hub/risk/indicators/completion/field/bind/business";

    // Cookie (从curl命令中提取，可能需要根据实际情况更新)
    private static final String COOKIE = "filter=%7B%22activitycode%22%3A%22PTYX-CNY-HBY-2026-24%22%2C%22catalog%22%3A%22rain%22%2C%22availableDuration%22%3Anull%7D; newOmsfilter=%7B%22time%22%3A%7B%22orderdate%22%3A%5B%222025-10-31T16%3A00%3A00.000Z%22%2C%222026-03-07T15%3A59%3A59.999Z%22%5D%7D%2C%22phones%22%3A%7B%22receiveorregisterphone%22%3A%2213328699987%22%7D%2C%22orderatsegment%22%3A%22202507-%22%7D; SECKEY_ABVK=cGhSMPLdh+20Qrdu1ozIjnw809Y36PAnfE1H6gZK5s4%3D; BMAP_SECKEY=eYYzvRFo_MX9SHZdB9oso_vDn8CMiAtIF7TsXledZOn5AD4_G1W5UF0zzHaxedI84v5BuSpyvuFrZR1MTjDlULMifZzH0awH6ZA88bJKHua2xgF-3NADOr451YOUVJ3WOdBryuJ9YU87-NeBcX0x2t1MAF03qJlFcflATs-LHknpNpc5e-q09NvjusZ-PjVx; sensorsdata2015jssdkchannel=%7B%22prop%22%3A%7B%22_sa_channel_landing_url%22%3A%22%22%7D%7D; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22197345925498b3-0d9f5bef6cca8d8-19525636-2073600-1973459254a4bf%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTk3MzQ1OTI1NDk4YjMtMGQ5ZjViZWY2Y2NhOGQ4LTE5NTI1NjM2LTIwNzM2MDAtMTk3MzQ1OTI1NGE0YmYifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%221904e4e47f9637-0dec8b9fa3daa3-19525637-1764000-1904e4e47fa725%22%7D; SECKEY_ABVK=1qLt4Quv3F+93B1SXjMUV2ngADeUedAzXhnd/TT4kfs%3D; BMAP_SECKEY=4LqESIqwFt4x7j_MOl5h2xNYCIvwmmjY-KYzr3rza90hWIqEYXaeo-ftlr5bOXY0JHipYZGMZvaLi5fooF4KUHCVyV_3V-NpddePQM9NExscDMniYeWkYuYwukTJFTOuoGz5z7dFsPgIhf3QGnVQLPSgOKnZiN6hp_XL8RuF9vKU2TfuJYce0zuiZH7-35LR1gQKLPa7JJQ9gAW_vfhUoskV3YIjmYWLoeAWfMrkjHY; appliedwebsid=6eecd9da-296d-4008-95c2-8e898f57c988; uploadticket=1jyt72yC8G2Uu5u-kwZtBhXANzBqu5-egs1FoHmHcfI=";

    /**
     * 发送HTTP POST请求
     *
     * @param businessCode 业务代码
     * @param fieldCode    字段代码
     * @return 响应结果
     */
    public static String sendRequest(String businessCode, String fieldCode) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(REQUEST_URL);
            conn = (HttpURLConnection) url.openConnection();

            // 设置请求方法
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            // 设置请求头
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            conn.setRequestProperty("Cookie", COOKIE);
            conn.setRequestProperty("Origin", "https://hc.yonghuivip.com");
            conn.setRequestProperty("Referer", "https://hc.yonghuivip.com/app/risk-web");
            conn.setRequestProperty("Sec-Fetch-Dest", "empty");
            conn.setRequestProperty("Sec-Fetch-Mode", "cors");
            conn.setRequestProperty("Sec-Fetch-Site", "same-origin");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/145.0.0.0 Safari/537.36");
            conn.setRequestProperty("sec-ch-ua", "\"Not:A-Brand\";v=\"99\", \"Google Chrome\";v=\"145\", \"Chromium\";v=\"145\"");
            conn.setRequestProperty("sec-ch-ua-mobile", "?0");
            conn.setRequestProperty("sec-ch-ua-platform", "\"macOS\"");

            // 构建请求体
            String requestBody = buildRequestBody(businessCode, fieldCode);

            // 发送请求体
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = requestBody.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // 读取响应
            int responseCode = conn.getResponseCode();
            BufferedReader reader;
            if (responseCode >= 200 && responseCode < 300) {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            } else {
                reader = new BufferedReader(new InputStreamReader(conn.getErrorStream(), StandardCharsets.UTF_8));
            }

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            return "Response Code: " + responseCode + ", Body: " + response.toString();

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    /**
     * 构建请求体JSON
     */
    private static String buildRequestBody(String businessCode, String fieldCode) {
        return "{"
                + "\"businessType\":\"2\","
                + "\"businessCode\":\"" + businessCode + "\","
                + "\"fieldParams\":\"memberId,deviceId\","
                + "\"defaultValue\":\"\\\"\\\"\","
                + "\"cacheType\":0,"
                + "\"fieldCode\":\"" + fieldCode + "\""
                + "}";
    }

    /**
     * 批量发送请求
     *
     * @param businessCodes 业务代码列表
     * @param fieldCodes    字段代码列表
     */
    public static void batchSendRequests(List<String> businessCodes, List<String> fieldCodes) {
        System.out.println("开始批量发送请求...");
        System.out.println("========================================");

        for (String businessCode : businessCodes) {
            for (String fieldCode : fieldCodes) {
                System.out.println("Processing: businessCode=" + businessCode + ", fieldCode=" + fieldCode);
                String result = sendRequest(businessCode, fieldCode);
                System.out.println("Result: " + result);
                System.out.println("----------------------------------------");

                // 添加短暂延迟，避免请求过快
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        System.out.println("========================================");
        System.out.println("批量请求完成！");
    }

    /**
     * 主方法 - 示例用法
     */
    public static void main(String[] args) {
        // 示例1: 自定义businessCode和fieldCode列表
        List<String> businessCodes = Arrays.asList(
                "122",
                "123",
                "125",
                "126",
                "129",
                "146",
                "202",
                "203",
                "209",
                "210",
                "233",
                "242",
                "245",
                "246",
                "252",
                "253",
                "260"
        );
        List<String> fieldCodes = Arrays.asList("gyroscopeVarianceX","gyroscopeVarianceY","gyroscopeVarianceZ");

        // 执行批量请求
        batchSendRequests(businessCodes, fieldCodes);

        // 示例2: 单个请求
        // System.out.println(sendRequest("233", "realTimeLongitude"));
    }
}
