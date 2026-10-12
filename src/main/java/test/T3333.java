package test;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import okhttp3.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class T3333 {

    public static void main(String[] args) {
        String url = "https://open.feishu.cn/open-apis/bot/v2/hook/576ea3bb-f13f-4497-9487-039a98e65128";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("任务id", 11);
        jsonObject.put("数据总量", 222);

        sendPost(url, null, "测试构建成功", jsonObject);
        System.out.println("hhhhhhhhhhhh");
    }

    private static final OkHttpClient CLIENT = new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build();

    private static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");

    /**
     * 发送纯文本消息
     */
    public static boolean sendText(String webhookUrl, String secret, String text) {
        JSONObject content = new JSONObject();
        content.put("text", text);
        return sendRequest(webhookUrl, secret, "text", content);
    }

    /**
     * 发送富文本消息（Post 类型，多行）
     * 传入的 content 必须是二维结构：外层是行，内层是节点数组
     * 例如：[[{"tag":"text","text":"第一行"}]]
     */
    public static boolean sendPost(String webhookUrl, String secret, String title, JSONArray content) {
        JSONObject zhCn = new JSONObject();
        zhCn.put("title", title);
        zhCn.put("content", content);

        JSONObject post = new JSONObject();
        post.put("zh_cn", zhCn);

        JSONObject contentNode = new JSONObject();
        contentNode.put("post", post);

        return sendRequest(webhookUrl, secret, "post", contentNode);
    }

    /**
     * 发送富文本消息（Post 类型，单行 key-value）
     * 自动把 JSONObject 拆成带 tag:text 的节点，并包成二维数组
     */
    public static boolean sendPost(String webhookUrl, String secret, String title, JSONObject jsonObject) {
        JSONArray line = new JSONArray();
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            JSONObject node = new JSONObject();
            node.put("tag", "text");
            node.put("text", entry.getKey() + "：" + entry.getValue() + "  ");
            line.add(node);
        }

        JSONArray content = new JSONArray();
        content.add(line);

        JSONObject zhCn = new JSONObject();
        zhCn.put("title", title);
        zhCn.put("content", content);

        JSONObject post = new JSONObject();
        post.put("zh_cn", zhCn);

        JSONObject contentNode = new JSONObject();
        contentNode.put("post", post);

        return sendRequest(webhookUrl, secret, "post", contentNode);
    }

    private static boolean sendRequest(String webhookUrl, String secret, String msgType, JSONObject content) {
        JSONObject body = new JSONObject();
        body.put("msg_type", msgType);
        body.put("content", content);

        if (secret != null && !secret.isEmpty()) {
            long timestamp = System.currentTimeMillis() / 1000;
            body.put("timestamp", String.valueOf(timestamp));
            body.put("sign", genSign(secret, timestamp));
        }

        RequestBody requestBody = RequestBody.create(JSON_TYPE, body.toJSONString());
        Request request = new Request.Builder()
                .url(webhookUrl)
                .post(requestBody)
                .build();

        try (Response response = CLIENT.newCall(request).execute()) {
            String respBody = response.body() != null ? response.body().string() : "";

            if (!response.isSuccessful()) {
                System.err.println("飞书发送失败: HTTP " + response.code() + ", body=" + respBody);
                return false;
            }
            if (respBody.isEmpty()) {
                return true;
            }

            JSONObject result = JSON.parseObject(respBody);
            int code = result != null ? result.getIntValue("code", 0) : 0;
            if (code != 0) {
                System.err.println("飞书发送失败: " + respBody);
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String genSign(String secret, long timestamp) {
        try {
            String stringToSign = timestamp + "\n" + secret;
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(stringToSign.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            return Base64.getEncoder().encodeToString(
                    mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new RuntimeException("飞书签名生成失败", e);
        }
    }
}