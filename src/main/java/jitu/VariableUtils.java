package jitu;

import com.alibaba.fastjson.JSON;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class VariableUtils {
//    private static final String DOMAIN_NAME = "https://demo-riskshield-inner.yunlu-tech.cn";
private static final String DOMAIN_NAME = "https://riskshield-inner.yunlu-tech.cn";
    private static final String URL = DOMAIN_NAME + "/riskshield/variable/save";
    private static final String AUTH_TOKEN = "cf83ffe2dce649e3b0e7f12e3a8a6d6f";
    public static String MetaData = "list.add(new RiskSourcePropResult(\"运单号\", \"waybillNo\", \"运单号\", VariableType.STRING.getCode(), paramObject.getString(\"waybillNo\")));\n" +
            "list.add(new RiskSourcePropResult(\"派件时间\", \"dispatchTime\", \"派件时间\", VariableType.DATE.getCode(), paramObject.getDate(\"dispatchTime\")));\n" +
            "list.add(new RiskSourcePropResult(\"客户编码\", \"customerCode\", \"客户编码\", VariableType.STRING.getCode(), paramObject.getString(\"customerCode\")));\n" +
            "list.add(new RiskSourcePropResult(\"客户名称\", \"customerName\", \"客户名称\", VariableType.STRING.getCode(), paramObject.getString(\"customerName\")));\n" +
            "list.add(new RiskSourcePropResult(\"订单来源编码\", \"orderSourceCode\", \"订单来源编码\", VariableType.STRING.getCode(), paramObject.getString(\"orderSourceCode\")));\n" +
            "list.add(new RiskSourcePropResult(\"订单来源名称\", \"orderSourceName\", \"订单来源名称\", VariableType.STRING.getCode(), paramObject.getString(\"orderSourceName\")));\n" +
            "list.add(new RiskSourcePropResult(\"寄件代理区编码\", \"sendAgentCode\", \"寄件代理区编码\", VariableType.STRING.getCode(), paramObject.getString(\"sendAgentCode\")));\n" +
            "list.add(new RiskSourcePropResult(\"寄件代理区名称\", \"sendAgentName\", \"寄件代理区名称\", VariableType.STRING.getCode(), paramObject.getString(\"sendAgentName\")));\n" +
            "list.add(new RiskSourcePropResult(\"寄件城市\", \"sendCity\", \"寄件城市\", VariableType.STRING.getCode(), paramObject.getString(\"sendCity\")));\n" +
            "list.add(new RiskSourcePropResult(\"寄件加盟商编码\", \"sendFranchiseCode\", \"寄件加盟商编码\", VariableType.STRING.getCode(), paramObject.getString(\"sendFranchiseCode\")));\n" +
            "list.add(new RiskSourcePropResult(\"寄件加盟商名称\", \"sendFranchiseName\", \"寄件加盟商名称\", VariableType.STRING.getCode(), paramObject.getString(\"sendFranchiseName\")));\n" +
            "list.add(new RiskSourcePropResult(\"寄件网点编码\", \"sendNetworkCode\", \"寄件网点编码\", VariableType.STRING.getCode(), paramObject.getString(\"sendNetworkCode\")));\n" +
            "list.add(new RiskSourcePropResult(\"寄件网点名称\", \"sendNetworkName\", \"寄件网点名称\", VariableType.STRING.getCode(), paramObject.getString(\"sendNetworkName\")));\n" +
            "list.add(new RiskSourcePropResult(\"派件代理区编码\", \"receiveAgentCode\", \"派件代理区编码\", VariableType.STRING.getCode(), paramObject.getString(\"receiveAgentCode\")));\n" +
            "list.add(new RiskSourcePropResult(\"派件代理区名称\", \"receiveAgentName\", \"派件代理区名称\", VariableType.STRING.getCode(), paramObject.getString(\"receiveAgentName\")));\n" +
            "list.add(new RiskSourcePropResult(\"派件城市\", \"receiveCity\", \"派件城市\", VariableType.STRING.getCode(), paramObject.getString(\"receiveCity\")));\n" +
            "list.add(new RiskSourcePropResult(\"派件加盟商编码\", \"receiveFranchiseCode\", \"派件加盟商编码\", VariableType.STRING.getCode(), paramObject.getString(\"receiveFranchiseCode\")));\n" +
            "\n" +
            "\n" +
            "list.add(new RiskSourcePropResult(\"派件加盟商名称\", \"receiveFranchiseName\", \"派件加盟商名称\", VariableType.STRING.getCode(), paramObject.getString(\"receiveFranchiseName\")));\n" +
            "list.add(new RiskSourcePropResult(\"派件网点编码\", \"receiveNetworkCode\", \"派件网点编码\", VariableType.STRING.getCode(), paramObject.getString(\"receiveNetworkCode\")));\n" +
            "list.add(new RiskSourcePropResult(\"派件网点名称\", \"receiveNetworkName\", \"派件网点名称\", VariableType.STRING.getCode(), paramObject.getString(\"receiveNetworkName\")));\n" +
            "list.add(new RiskSourcePropResult(\"派件详细地址明文\", \"receiveAddressPlain\", \"派件详细地址明文\", VariableType.STRING.getCode(), paramObject.getString(\"receiveAddressPlain\")));\n" +
            "list.add(new RiskSourcePropResult(\"收件人（脱敏）\", \"receiverNameMasked\", \"收件人（脱敏）\", VariableType.STRING.getCode(), paramObject.getString(\"receiverNameMasked\")));\n" +
            "list.add(new RiskSourcePropResult(\"收件人手机号（脱敏）\", \"receiverPhoneMasked\", \"收件人手机号（脱敏）\", VariableType.STRING.getCode(), paramObject.getString(\"receiverPhoneMasked\")));\n" +
            "list.add(new RiskSourcePropResult(\"派件员工工号\", \"dispatchStaffCode\", \"派件员工工号\", VariableType.STRING.getCode(), paramObject.getString(\"dispatchStaffCode\")));\n" +
            "list.add(new RiskSourcePropResult(\"派件员工手机号（脱敏）\", \"dispatchStaffPhoneMasked\", \"派件员工手机号（脱敏）\", VariableType.STRING.getCode(), paramObject.getString(\"dispatchStaffPhoneMasked\")));\n" +
            "\n" +
            "list.add(new RiskSourcePropResult(\"揽收业务员工号\", \"collectStaffCode\", \"揽收业务员工号\", VariableType.STRING.getCode(), paramObject.getString(\"collectStaffCode\")));\n" +
            "list.add(new RiskSourcePropResult(\"计费重量\", \"chargeWeight\", \"计费重量\", VariableType.FLOAT.getCode(), paramObject.getDouble(\"chargeWeight\")));\n" +
            "list.add(new RiskSourcePropResult(\"是否高派费网点\", \"isHighDeliveryFee\", \"是否高派费网点 1=是 0=否\", VariableType.INT.getCode(), paramObject.getInteger(\"isHighDeliveryFee\")));\n" +
            "list.add(new RiskSourcePropResult(\"是否使用三方工具\", \"isUseThirdTool\", \"是否使用三方工具 1=是 0=否\", VariableType.INT.getCode(), paramObject.getInteger(\"isUseThirdTool\")));\n" +
            "\n" +
            "list.add(new RiskSourcePropResult(\"异常运单匹配分数\", \"matchScore\", \"异常运单匹配分数\", VariableType.FLOAT.getCode(), paramObject.getDouble(\"matchScore\")));\n" +
            "list.add(new RiskSourcePropResult(\"地址库poi\", \"addressPoi\", \"地址库poi\", VariableType.STRING.getCode(), paramObject.getString(\"addressPoi\")));\n" +
            "list.add(new RiskSourcePropResult(\"加密寄件人姓名\", \"senderNameMasked\", \"加密寄件人姓名\", VariableType.STRING.getCode(), paramObject.getString(\"senderNameMasked\")));\n" +
            "list.add(new RiskSourcePropResult(\"脱敏寄件人手机号\", \"senderPhoneMasked\", \"脱敏寄件人手机号\", VariableType.STRING.getCode(), paramObject.getString(\"senderPhoneMasked\")));\n" +
            "list.add(new RiskSourcePropResult(\"寄件时间\", \"deliveryTime\", \"寄件时间\", VariableType.DATE.getCode(), paramObject.getDate(\"deliveryTime\")));";

    public static void main(String[] args) throws InterruptedException {
        String[] split = MetaData.split(";");
        for (String string : split) {
            String[] innerSplit = string.split(",");
            String variableCode = innerSplit[1].split("\"")[1];
            String variableName = innerSplit[2].split("\"")[1];
            String variableType = innerSplit[3].split("\\.")[1];


            Map<String, Object> params = new HashMap<>();
            params.put("variableCode", variableCode);
            params.put("variableName", variableName);
            params.put("variableCategory", "PROPERTY");
            params.put("variableType", variableType);
            String result = saveVariable(params);
            Thread.sleep(3000L);
            System.out.println(result);
        }

    }


    public static String saveVariable(Map<String, Object> params) {
        OkHttpClient client = new OkHttpClient();

        String json = JSON.toJSONString(params);

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"),
                json
        );

        Request request = new Request.Builder()
                .url(URL)
                .post(body)
                .header("Accept", "application/json, text/plain, */*")
                .header("Accept-Language", "zh-CN,zh;q=0.9")
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/json")
                .header("Origin", "https://demo-riskshield-inner.yunlu-tech.cn")
                .header("Referer", "https://demo-riskshield-inner.yunlu-tech.cn/")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "same-origin")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/151.0.0.0 Safari/537.36")
                .header("authToken", AUTH_TOKEN)
                .header("sec-ch-ua", "\"Not=A?Brand\";v=\"99\", \"Google Chrome\";v=\"151\", \"Chromium\";v=\"151\"")
                .header("sec-ch-ua-mobile", "?0")
                .header("sec-ch-ua-platform", "\"Windows\"")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body() != null ? response.body().string() : "";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}