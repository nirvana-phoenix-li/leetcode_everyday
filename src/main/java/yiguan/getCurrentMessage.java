package yiguan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class getCurrentMessage {
    public static void main(String[] args) {
        String apiUrl = "https://api.jijigugu.club/feed/list";
        String age = "%5B%2285%2B%22%2C%2280-%22%2C%2200%2B%22%2C%2295%2B%22%2C%2205%2B%22%2C%2290%2B%22%2C%2280%2B%22%5D";
        String deviceId = "453A6392-B25B-42E5-83B2-A44BE925F29A";
        String dist = "appstore";
        String gender = "%5B2%2C1%5D";
        String mid = "N3ZOwLQXplgEdW82v0Bn";
        String model = "iPad12,1";
        String osVersion = "16.5";
        String platform = "2";
        String secondsFromGMT = "28800";
        String smDeviceId = "20230202141426a7a5cdad2fa1057f438d56267e2f453301393414525fe7a8";
        String version = "3.14.6";
        String xJikeDeviceProperties = "%7B%22idfa%22%3A%2200000000-0000-0000-0000-000000000000%22%2C%22idfv%22%3A%2219194B78-F8D8-48A1-8CBF-E9C706D5296B%22%7D";
        String ygtHeader = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjgxMDQwMzEsImV4cCI6MTY5MTk5MzU5NX0.Vwu5LF8mqUSIUjcCIOT9V705YhCkYUNXiLC-ffaB5YY";
        String appPermissionsHeader = "6";
        String userAgentHeader = "guan/3.14.6 (club.jijigugu.yiguan; build:722; iOS 16.5.0) Alamofire/5.1.0";
        String acceptLanguageHeader = "zh-Hans-CN;q=1.0";

        try {
            // 构建带有查询参数的请求URL
            String fullUrl = apiUrl + "?age=" + age + "&deviceId=" + deviceId + "&dist=" + dist + "&gender=" + gender +
                    "&mid=" + mid + "&model=" + model + "&os_version=" + osVersion + "&platform=" + platform +
                    "&secondsFromGMT=" + secondsFromGMT + "&smDeviceId=" + smDeviceId + "&version=" + version +
                    "&x-jike-device-properties=" + xJikeDeviceProperties;

            // 创建URL对象
            URL url = new URL(fullUrl);

            // 打开连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // 设置请求头部
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Host", "api.jijigugu.club");
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("ygt", ygtHeader);
            conn.setRequestProperty("app-permissions", appPermissionsHeader);
            conn.setRequestProperty("user-agent", userAgentHeader);
            conn.setRequestProperty("accept-language", acceptLanguageHeader);

            // 发送请求并获取响应码
            int responseCode = conn.getResponseCode();

            // 读取响应内容
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // 打印响应信息
            System.out.println("响应码: " + responseCode);
            System.out.println("响应内容: " + response.toString());

            // 关闭连接
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
