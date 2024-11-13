package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TestReadTxtLine {
    public static void main(String[] args) throws IOException, WriteException {
        String filePath = "ten_minute.txt"; // 替换成你的文件路径

        long first = System.currentTimeMillis();
        File outputFile = new File("十分钟.xlsx");
        // 创建一个工作簿
        WritableWorkbook outputbook = Workbook.createWorkbook(outputFile);

        // 创建一个工作表
        WritableSheet outputSheet = outputbook.createSheet("sheet1", 0);


        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            int currentLine = 1;

            HashMap<String, Integer> diction = new HashMap<>();
            diction.put("traceId", 0);
            diction.put("datetime", 1);
            int dictionIndex = 2;


            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals("")) {
                    currentLine++;
                    continue;
                }

                JSONObject metaJson = JSON.parseObject(line);
                String datetime = metaJson.getString("datetime");

                String string = metaJson.getString("content");
                String traceId = string.split("] 进入浏览反爬风控")[0].substring(6);

                String[] split = string.split("YHRiskTaskRequest:");
                int length = split[1].length();
                String substring = split[1].substring(0, length - 2);
                JSONObject content = JSON.parseObject(substring);
                JSONObject innerContent = content.getJSONObject("content");

                outputSheet.addCell(new Label(0, currentLine, traceId));
                outputSheet.addCell(new Label(1, currentLine, datetime));

                for (String s : innerContent.keySet()) {
                    if (innerContent.get(s) != null) {
                        if (!diction.containsKey(s)) {
                            diction.put(s, dictionIndex++);
                        }
                        Integer location = diction.get(s);

                        outputSheet.addCell(new Label(location, currentLine, innerContent.getString(s)));
                    }
                }

                currentLine++;
            }

            for (String s : diction.keySet()) {
                outputSheet.addCell(new Label(diction.get(s), 0, s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        outputbook.write();
        outputbook.close();
        System.out.println(System.currentTimeMillis() - first);


    }
}
