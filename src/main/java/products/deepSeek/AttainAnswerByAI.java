package products.deepSeek;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class AttainAnswerByAI {

    public static void main(String[] args) {
        try {
            readAndWrite();
//            String response = simpleRequest("");
//            System.out.println("Response:################################################################## ");
//            String[] split = response.split("###");
//            String treasure = split[1].replace("\\", "");
//            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readAndWrite() throws IOException, BiffException, WriteException {
        File xlsFile = new File("异常地址样本输入.xls");
        File outputFile = new File("DeepSeek分析风险地址结果.xls");
        // 获得工作簿对象
        Workbook workbook = Workbook.getWorkbook(xlsFile);
        WritableWorkbook workbook2 = Workbook.createWorkbook(outputFile);
        // 创建一个工作表
        WritableSheet writeSheet = workbook2.createSheet("sheet1", 0);
        // 获得所有工作表
        Sheet[] sheets = workbook.getSheets();
        // 遍历工作表
        if (sheets != null) {
            for (Sheet sheet : sheets) {
                // 获得行数
                int rows = sheet.getRows();
                // 获得列数
                int cols = sheet.getColumns();
                // 读取数据
                for (int row = 1; row < rows; row++) {
                    String addressFeature = sheet.getCell(5, row).getContents() + sheet.getCell(7, row).getContents();

                    String orderId = sheet.getCell(0, row).getContents();
                    String answer = "";
                    try {
                        answer = simpleRequest(addressFeature);
                        assert answer != null;
                        String[] split = answer.split("###");
                        String treasure = split[split.length - 2].replace("\\", "");

                        JSONObject jsonObject = JSON.parseObject(treasure);

                        String isRisk = jsonObject.getString("is_risk");
                        String score = jsonObject.getString("score");
                        String reason = jsonObject.getString("reason");


                        writeSheet.addCell(new Label(0, row, orderId));
                        writeSheet.addCell(new Label(1, row, addressFeature));

                        writeSheet.addCell(new Label(2, row, isRisk));
                        writeSheet.addCell(new Label(3, row, score));
                        writeSheet.addCell(new Label(4, row, reason));
                        System.out.println("第几行" + row + "已执行完成");
                    } catch (Exception e) {
                        System.out.println("第几行" + row + "出现问题了" + answer);
                        System.out.println(Arrays.toString(e.getStackTrace()));
                    }
//                    countRow++;
                }
            }
        }
        workbook2.write();
        workbook2.close();
        workbook.close();
    }

    public static String simpleRequest(String featureString) {
        try {
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(120, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build();
//        featureString="福州紫光商业小镇-2号门6栋A座808B-N11";
            String json = "{\n" +
                    "    \"model\": \"DeepSeek-R1-Distill-Llama-70B\",\n" +
                    "    \"messages\": [\n" +
                    "        {\n" +
                    "            \"role\": \"user\",\n" +
                    "            \"content\": \"你现在是一个专业的地址风险评估专家。请评估以下地址的风险，并以JSON格式返回结果。\\n\\n评估标准:\\n1. 返回格式: 必须是JSON，包含三个字段：is_risk (布尔值), score (0-100的整数), 和 reason (字符串)。\\n2. 风险判断:\\n * 高风险 (is_risk: true, score: 80-100): 地址异常，可能是虚假地址。例如，包含非标准小区名、楼栋号、房号，或包含可疑的数字/字母组合。\\n * 中风险 (is_risk: true, score: 40-79): 地址信息不完整或存在疑点，但无法完全确定为虚假。\\n * 正常 (is_risk: false, score: 0-39): 地址看起来是真实、完整的。\\n3. 原因解释 (reason): 必须使用中文解释。清晰、简洁地说明判断风险等级的理由。\\n\\n示例:\\n* 高风险地址:\\n * 13栋2单元213312W: 地址以一串可疑的数字和字母结尾（213312W），这通常是虚假地址的标志。\\n * 广东省广州市白云区黄石街道全有美食城附近: 地址过于模糊，没有精确到具体的楼栋和门牌号，无法确认其真实性。\\n * 一个不存在的小区33栋: 地址中包含'一个不存在的小区'，这显然是编造的。\\n* 正常地址:\\n * 广东省广州市海珠区新港中路397号: 地址清晰、完整，包含了省、市、区、街道和门牌号，是标准的真实地址。\\n * 幸福小区3栋2单元1502: 地址结构标准，包含小区、楼栋、单元和房号，符合正常地址的格式。\\n\\n现在，请评估这个地址: " +
                    featureString +
                    "，返回的标准json前面必须紧跟加上###，后面必须紧跟也加上###，json不用格式化和换行，给我纯文本就好，#前后也不用换行\"\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"max_tokens\": 1000\n" +
                    "}";

            Request request = new Request.Builder()
                    .url("http://59.37.128.77:18080/v1/chat/completions")
                    .post(RequestBody.create(json, MediaType.parse("application/json")))
                    .addHeader("Authorization", "Basic eFBhYlppQ3ZWWG9kM01BaWhlV1YyU1BVa3hRSFc4Qms5dXQ3NmFaSndRZzpRajZ4cjVxY2RERGh6R3dC")
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    return response.body().string();
                } else {
                    throw new IOException("HTTP " + response.code() + " - " + response.message());
                }
            }
        } catch (Exception e) {
            System.out.println("发送http请求或者解析时出现error" + Arrays.toString(e.getStackTrace()));
        }
        return null;
    }
}

