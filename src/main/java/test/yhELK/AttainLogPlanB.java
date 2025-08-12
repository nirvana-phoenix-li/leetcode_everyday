package test.yhELK;

import com.alibaba.fastjson.JSONObject;
import entity.Indicator;
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
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class AttainLogPlanB {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 16; i++) {
            executor(i);
        }
        readAndWrite();
    }

    private static void readAndWrite() throws IOException, BiffException, WriteException {
        HashMap<String, Set<String>> hashMap = new HashMap<>();
        for (int i = 0; i < 24; i++) {
            File xlsFile = new File("请求指标PlanB" + i + ".xlsx");
            Workbook workbook = Workbook.getWorkbook(xlsFile);
            Sheet[] sheets = workbook.getSheets();

            if (sheets != null) {
                for (Sheet sheet : sheets) {
                    // 获得行数
                    int rows = sheet.getRows();
                    // 获得列数
                    int cols = sheet.getColumns();
                    // 读取数据
                    int countRow = 0;
                    for (int row = 1; row < rows; row++) {
                        String esKey = sheet.getCell(0, row).getContents();
                        String indicator = sheet.getCell(1, row).getContents();

                        if (hashMap.containsKey(esKey)) {
                            Set<String> stringSet = hashMap.get(esKey);
                            extracted(indicator, stringSet);
                        } else {
                            Set<String> stringSet = new HashSet<>();
                            extracted(indicator, stringSet);
                            hashMap.put(esKey, stringSet);
                        }
                    }
                }
            }
        }


        File outputFile = new File("请求指标PlanB_total.xlsx");
        // 创建一个工作簿
        WritableWorkbook outputbook = Workbook.createWorkbook(outputFile);

        // 创建一个工作表
        WritableSheet outputSheet = outputbook.createSheet("sheet1", 1);

        // 添加表头
        outputSheet.addCell(new Label(0, 0, "esKey"));
        outputSheet.addCell(new Label(1, 0, "时间列表"));

        int rowIndex = 1;
        for (String esKey : hashMap.keySet()) {
            // 向工作表中添加数据
            outputSheet.addCell(new Label(0, rowIndex, esKey));
            outputSheet.addCell(new Label(1, rowIndex, hashMap.get(esKey).toString()));
            rowIndex++;
        }

        outputbook.write();
        outputbook.close();
        System.out.println("Excel文件已生成: " + outputFile.getAbsolutePath());
    }

    private static void extracted(String s, Set<String> hashSet) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                continue;
            } else if (s.charAt(i) == ',' || s.charAt(i) == ']') {
                hashSet.add(sb.toString());
                sb = new StringBuilder();
                i++;
            } else {
                sb.append(s.charAt(i));
            }
        }
    }

    private static void executor(int number) throws IOException, WriteException {
        String matchString = "风控特征计算服务queryFeatureEsOriginalResult。参数：";
        String endString = "\"";
        HashMap<String, Set<String>> hashMap = new HashMap<>();

        //实际查询时间是 8个小时之后，有时差
        int stepSecond = 3;
        LocalDateTime originalStart = LocalDateTime.of(2025, 7, 3, number, 0, 0, 0);
        LocalDateTime originalEnd = originalStart.plusSeconds(stepSecond);

        int requestCount = 0;
        for (int k = 0; k < 20 * 60; k++) {

            HashMap<String, String> stringHashMap = new HashMap<>();
            stringHashMap.put("进入", "");
            stringHashMap.put("结束", "and");

            String response = null;
            int redo = 0;
            while (response == null || response.startsWith("{\"id\"")) {
                redo++;
                response = callElasticSearchAPI(originalStart.toString(), originalEnd.toString(), stringHashMap);
            }
            System.out.println("当前为第" + k + "次，重试次数为: " + (redo - 1));
            System.out.println("API响应长度: " + response.length());

            for (int i = 0; i < response.length(); i++) {
                if (isMatch(response, i, matchString)) {
                    i += matchString.length();
                    StringBuilder sb = new StringBuilder();
                    Indicator indicator = new Indicator();
                    boolean satisfied = false;
                    for (int j = i; j < Integer.MAX_VALUE; j++) {
                        if (!satisfied) {
                            if (response.charAt(j) != ',') {
                                sb.append(response.charAt(j));
                            } else {
                                satisfied = true;
                                indicator.setTime(sb.toString());
                            }
                        } else {
                            if (isMatch(response, j, endString)) {
                                indicator.setEsKey(sb.toString());
                                i = j;
                                break;
                            }
                            if (response.charAt(j) == '_') {
                                sb = new StringBuilder();
                            } else {
                                sb.append(response.charAt(j));
                            }
                        }
                    }
                    requestCount++;

                    if (hashMap.containsKey(indicator.getEsKey())) {
                        hashMap.get(indicator.getEsKey()).add(indicator.getTime());
                    } else {
                        HashSet<String> hashSet = new HashSet<>();
                        hashSet.add(indicator.getTime());
                        hashMap.put(indicator.getEsKey(), hashSet);
                    }

                }

            }
            originalStart = originalStart.plusSeconds(stepSecond);
            originalEnd = originalEnd.plusSeconds(stepSecond);

        }

        System.out.println("找到 " + requestCount + " 条匹配记录");
        System.out.println("解析到 " + hashMap.size() + " 个不同的esKey");

        File outputFile = new File("请求指标PlanB" + number + ".xlsx");
        // 创建一个工作簿
        WritableWorkbook outputbook = Workbook.createWorkbook(outputFile);

        // 创建一个工作表
        WritableSheet outputSheet = outputbook.createSheet("sheet1", 1);

        // 添加表头
        outputSheet.addCell(new Label(0, 0, "esKey"));
        outputSheet.addCell(new Label(1, 0, "时间列表"));

        int rowIndex = 1;
        for (String esKey : hashMap.keySet()) {
            // 向工作表中添加数据
            outputSheet.addCell(new Label(0, rowIndex, esKey));
            outputSheet.addCell(new Label(1, rowIndex, hashMap.get(esKey).toString()));
            rowIndex++;
        }

        outputbook.write();
        outputbook.close();
        System.out.println("Excel文件已生成: " + outputFile.getAbsolutePath());
    }

    public static boolean isMatch(String text, int index, String matchString) {
        int length = matchString.length();
        for (int i = index; i < index + length; i++) {
            if (text.charAt(i) != matchString.charAt(i - index)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 调用ElasticSearch API的方法
     * 对应新的curl命令的Java实现
     */
    public static String callElasticSearchAPI(String startTime, String endTime, HashMap<String, String> inputHashMap) throws IOException {
        // 请求URL
        String url = "https://es-elk-kibana2.yonghuivip.com/s/cp-hcfk/internal/search/ese";

        // 构建请求体JSON
        JSONObject requestBody = new JSONObject();
        JSONObject params = new JSONObject();
        JSONObject body = new JSONObject();

        // 设置基本参数
        params.put("index", "*:logstash*cp-hcfk_risk-center_2*");

        // 设置body内容
        body.put("version", true);
        body.put("size", 1000);

        // 设置排序
        JSONObject sortObj = new JSONObject();
        JSONObject timestampSort = new JSONObject();
        timestampSort.put("order", "desc");
        timestampSort.put("unmapped_type", "boolean");
        sortObj.put("@timestamp", timestampSort);
        body.put("sort", new Object[]{sortObj});

        // 设置聚合
        JSONObject aggs = new JSONObject();
        JSONObject agg2 = new JSONObject();
        JSONObject dateHistogram = new JSONObject();
        dateHistogram.put("field", "@timestamp");
        dateHistogram.put("fixed_interval", "100ms");
        dateHistogram.put("time_zone", "Asia/Shanghai");
        dateHistogram.put("min_doc_count", 1);
        agg2.put("date_histogram", dateHistogram);
        aggs.put("2", agg2);
        body.put("aggs", aggs);

        // 设置字段
        body.put("stored_fields", new String[]{"*"});
        body.put("script_fields", new JSONObject());

        JSONObject docvalueField = new JSONObject();
        docvalueField.put("field", "@timestamp");
        docvalueField.put("format", "date_time");
        body.put("docvalue_fields", new Object[]{docvalueField});

        JSONObject source = new JSONObject();
        source.put("excludes", new String[]{});
        body.put("_source", source);

        // 设置查询
        JSONObject query = new JSONObject();
        JSONObject boolQuery = new JSONObject();
        boolQuery.put("must", new Object[]{});

        JSONObject multiMatchWrapper = new JSONObject();

        int size = inputHashMap.size();

        List<String> collect = inputHashMap.keySet().stream().collect(Collectors.toList());
        cursiveMultipalParam(inputHashMap, collect, size, multiMatchWrapper);

        JSONObject rangeQuery = new JSONObject();
        JSONObject timestampRange = new JSONObject();
        // 修复时间格式，确保包含秒和毫秒
        String gte = startTime.length() == 16 ? startTime + ":00.000Z" : startTime + ".000Z";
        String lte = endTime.length() == 16 ? endTime + ":00.000Z" : endTime + ".000Z";
        timestampRange.put("gte", gte);
        timestampRange.put("lte", lte);
        timestampRange.put("format", "strict_date_optional_time");
        rangeQuery.put("@timestamp", timestampRange);

        JSONObject rangeWrapper = new JSONObject();
        rangeWrapper.put("range", rangeQuery);
        boolQuery.put("filter", new Object[]{multiMatchWrapper, rangeWrapper});
        boolQuery.put("should", new Object[]{});
        boolQuery.put("must_not", new Object[]{});
        query.put("bool", boolQuery);
        body.put("query", query);

        // 设置高亮
        JSONObject highlight = new JSONObject();
        highlight.put("pre_tags", new String[]{"@kibana-highlighted-field@"});
        highlight.put("post_tags", new String[]{"@/kibana-highlighted-field@"});
        highlight.put("fields", new JSONObject().put("*", new JSONObject()));
        highlight.put("fragment_size", 2147483647);
        body.put("highlight", highlight);

        params.put("body", body);
        params.put("preference", 1751449377180L);
        requestBody.put("params", params);

        // 创建OkHttp客户端
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

        // 创建请求体
        RequestBody bodyContent = RequestBody.create(
                MediaType.parse("application/json"),
                requestBody.toJSONString()
        );

        // 创建HTTP请求
        Request request = new Request.Builder()
                .url(url)
                .header("content-type", "application/json")
                .header("kbn-version", "7.10.1")
                .post(bodyContent)
                .build();

        // 发送请求并获取响应
        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();

        if (!response.isSuccessful()) {
            System.err.println("HTTP错误: " + response.code() + " " + response.message());
            System.err.println("响应体: " + responseBody);
            throw new IOException("Unexpected response code: " + response.code() + " " + response.message());
        }

        return responseBody;
    }

    private static void cursiveMultipalParam(HashMap<String, String> inputHashMap, List<String> indexList, int size, JSONObject headJsonObject) {
        size--;

        JSONObject multiMatch = new JSONObject();
        String s = inputHashMap.get(indexList.get(size));
        if (size != 0) {
            JSONObject cursiveBool = new JSONObject();
            JSONObject cursiveJson = new JSONObject();

            JSONObject paramsJson = new JSONObject();
            String first = indexList.get(size);
            String second = inputHashMap.get(first);
            paramsJson.put("type", "phrase");
            paramsJson.put("query", first);
            paramsJson.put("lenient", true);

            if ("and not".equals(second)) {
                JSONObject paramsBool = new JSONObject();
                headJsonObject.put("bool", paramsBool);
                JSONObject mustNot = new JSONObject();
                paramsBool.put("must_not", mustNot);
                mustNot.put("multi_match", paramsJson);
                cursiveBool.put("filter", new Object[]{cursiveJson, paramsBool});

            } else {
                cursiveBool.put("filter", new Object[]{cursiveJson, paramsJson});
            }
            headJsonObject.put("bool", cursiveBool);
            cursiveMultipalParam(inputHashMap, indexList, size, cursiveJson);


        } else {
//            if (inputHashMap.get(s) != null && "and not".equals(inputHashMap.get(s))) {
//                JSONObject mustNot = new JSONObject();
//                headJsonObject.put("must_not", mustNot);
//                mustNot.put("multi_match", multiMatch);
//            } else {
//                headJsonObject.put("multi_match", multiMatch);
//            }
            headJsonObject.put("type", "phrase");
            headJsonObject.put("query", indexList.get(size));
            headJsonObject.put("lenient", true);
        }
    }


}
