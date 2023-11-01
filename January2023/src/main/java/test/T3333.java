package test;

import com.alibaba.fastjson.JSONObject;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import okhttp3.Response;
import utils.HttpClient;

import java.io.File;
import java.util.Objects;

public class T3333 {
    public static void main(String[] args) throws Exception {
        File outputFile = new File("测试环境一万个测试用户token.xls");
        // 创建一个工作簿
        WritableWorkbook outputbook = Workbook.createWorkbook(outputFile);
        // 创建一个工作表
        WritableSheet outputSheet = outputbook.createSheet("sheet1", 0);
        for (int row = 1; row <= 10000; row++) {
            outputSheet.addCell(new Label(0, row, String.valueOf(row)));
            String token = getToken(String.valueOf(row));
            outputSheet.addCell(new Label(1, row, token));
            System.out.println(row);
        }
        outputbook.write();
        outputbook.close();
    }


    private static String getToken(String memberId) {
        String token = "";
        HttpClient httpClient1 = new HttpClient();
        String url = "https://dev-api.sweet7.com/auth/gettokenbyjsonuserinfo";
        Response response1 = null;
        try {
            JSONObject jsonObject = new JSONObject();
            JSONObject body = new JSONObject();
            body.put("channel", "weixin");
            body.put("days", 10000);
            body.put("memberId", memberId);
            jsonObject.put("body", body);
            String jsonString = jsonObject.toJSONString();
            response1 = httpClient1.postByJson(url, jsonString);
            String result = response1.body().string();
            token = result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (Objects.nonNull(response1)) {
                    response1.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
        return token;
    }
}
