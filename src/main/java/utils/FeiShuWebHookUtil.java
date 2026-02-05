package utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class FeiShuWebHookUtil {


    /**
     * 发送飞书卡片消息
     *
     * @param webhookUrl 飞书webhook地址
     * @param title      消息标题
     * @param contentMap 内容键值对
     */
    public static void sendFeishuCard(String webhookUrl, String title, Map<String, String> contentMap) {
        try {
            // 构建markdown内容
            StringBuilder contentBuilder = new StringBuilder();
            for (Map.Entry<String, String> entry : contentMap.entrySet()) {
                contentBuilder.append("- **")
                        .append(entry.getKey())
                        .append("**:\t")
                        .append(entry.getValue())
                        .append("\n");
            }

            // 构建请求体
            JSONObject requestBody = new JSONObject();
            requestBody.put("msg_type", "interactive");


            JSONObject card = new JSONObject();

            // config
            JSONObject config = new JSONObject();
            config.put("wide_screen_mode", true);
            card.put("config", config);

            // header
            JSONObject header = new JSONObject();
            JSONObject titleObj = new JSONObject();
            titleObj.put("tag", "plain_text");
            titleObj.put("content", title);
            header.put("title", titleObj);
            header.put("template", "blue");
            card.put("header", header);

            // elements
            JSONObject markdown = new JSONObject();
            markdown.put("tag", "markdown");
            markdown.put("content", contentBuilder.toString());

            JSONArray elements = new JSONArray();
            elements.add(markdown);
            card.put("elements", elements);

            requestBody.put("card", card);

            // 发送HTTP请求
            sendHttpPost(webhookUrl, requestBody);

        } catch (Exception e) {
            throw new RuntimeException("飞书消息发送异常: " + e.getMessage(), e);
        }
    }


    /**
     * 发送HTTP POST请求
     */
    private static void sendHttpPost(String url, JSONObject requestBody) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;

        try {
            // 创建HttpClient
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(5000)
                    .setSocketTimeout(10000)
                    .build();

            httpClient = HttpClients.custom()
                    .setDefaultRequestConfig(requestConfig)
                    .build();

            // 创建POST请求
            HttpPost httpPost = new HttpPost(url);

            // 设置请求头
            httpPost.setHeader("Content-Type", "application/json");

            // 设置请求体
            String requestBodyStr = requestBody.toJSONString();
            StringEntity entity = new StringEntity(requestBodyStr, StandardCharsets.UTF_8);
            httpPost.setEntity(entity);

            // 执行请求
            response = httpClient.execute(httpPost);

            // 获取响应状态码
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("HTTP请求失败，状态码: " + statusCode);
            }

            // 读取响应内容
            String responseStr = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            JSONObject responseObj = JSONObject.parseObject(responseStr);

            // 检查飞书响应
            Integer code = responseObj.getInteger("code");
            if (code != null && code != 0) {
                String msg = responseObj.getString("msg");
                throw new RuntimeException("飞书返回错误: " + msg + " (code: " + code + ")");
            }

        } catch (Exception e) {
            throw new RuntimeException("HTTP请求异常: " + e.getMessage(), e);
        } finally {
            // 关闭资源
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (Exception e) {
                // 忽略关闭异常
            }
        }
    }


    /**
     * 使用示例
     */
    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();
        params.put("系统名称", "生产环境服务器");
        params.put("IP地址", "192.168.1.100");
        params.put("操作系统", "CentOS 7.9");

        sendFeishuCard(
                "https://open.feishu.cn/open-apis/bot/v2/hook/918a2de1-6c65-43a5-a806-debea58ff966",
                "Markdown 消息示例",
                params
        );
    }
}