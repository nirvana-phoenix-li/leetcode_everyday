package test.yhELK;

import com.alibaba.fastjson.JSONObject;
import entity.Indicator;
import jxl.Workbook;
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
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AttainLog {
    public static void main(String[] args) throws IOException, WriteException {
        String matchString = "风控特征计算服务queryFeatureEsOriginalResult。参数：";
        String endString = "\"";
        HashMap<String, Set<String>> hashMap = new HashMap<>();

        LocalDateTime originalStart = LocalDateTime.of(2025, 7, 3, 16, 2,0);
        LocalDateTime originalEnd = originalStart.plusSeconds(60);

        int requestCount = 0;
        for (int k = 0; k < 1; k++) {

            String response = callElasticSearchAPI(originalStart.toString(), originalEnd.toString());
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
            originalStart = originalStart.plusSeconds(60);
            originalEnd = originalEnd.plusSeconds(60);

        }


        File outputFile = new File("请求指标" + ".xlsx");
        // 创建一个工作簿
        WritableWorkbook outputbook = Workbook.createWorkbook(outputFile);

        // 创建一个工作表
        WritableSheet outputSheet = outputbook.createSheet("sheet1", 0);

        int rowIndex=1;
        for (String esKey : hashMap.keySet()) {
            // 向工作表中添加数据
            outputSheet.addCell(new Label(0, rowIndex, esKey));
            outputSheet.addCell(new Label(1, rowIndex, hashMap.get(esKey).toString()));
            rowIndex++;
        }

        outputbook.write();
        outputbook.close();
        System.out.println("jieshu");
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
     * 对应curl命令的Java实现
     */
    public static String callElasticSearchAPI(String startTime, String endTime) throws IOException {
        // 请求URL
        String url = "https://es-elk-kibana2.yonghuivip.com/s/cp-hcfk/internal/search/ese";

        // 构建请求体JSON
        JSONObject requestBody = new JSONObject();
        JSONObject params = new JSONObject();
        JSONObject body = new JSONObject();

        // 设置基本参数
        params.put("index", "*:logstash*cp-hcfk_risk-core_2*");

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

        JSONObject multiMatch = new JSONObject();
        multiMatch.put("type", "phrase");
        multiMatch.put("query", "风控特征计算服务");
        multiMatch.put("lenient", true);

        JSONObject rangeQuery = new JSONObject();
        JSONObject timestampRange = new JSONObject();
        timestampRange.put("gte", startTime + "Z");
        timestampRange.put("lte", endTime + "Z");
        timestampRange.put("format", "strict_date_optional_time");
        rangeQuery.put("@timestamp", timestampRange);

        boolQuery.put("filter", new Object[]{new JSONObject().put("multi_match", multiMatch), new JSONObject().put("range", rangeQuery)});
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
//                .addHeader("accept", "*/*")
//                .addHeader("accept-language", "zh-CN,zh;q=0.9")
//                .addHeader("content-type", "application/json")
//                .addHeader("kbn-version", "7.10.1")
                .header("content-type", "application/json")
                .header("kbn-version", "7.10.1")

//                .addHeader("origin", "https://es-elk-kibana2.yonghuivip.com")
//                .addHeader("priority", "u=1, i")
//                .addHeader("referer", "https://es-elk-kibana2.yonghuivip.com/s/cp-hcfk/app/discover")
//                .addHeader("sec-ch-ua", "\"Google Chrome\";v=\"137\", \"Chromium\";v=\"137\", \"Not/A)Brand\";v=\"24\"")
//                .addHeader("sec-ch-ua-mobile", "?0")
//                .addHeader("sec-ch-ua-platform", "\"macOS\"")
//                .addHeader("sec-fetch-dest", "empty")
//                .addHeader("sec-fetch-mode", "cors")
//                .addHeader("sec-fetch-site", "same-origin")
//                .addHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36")
//                .addHeader("Cookie", "sensorsdata2015jssdkchannel=%7B%22prop%22%3A%7B%22_sa_channel_landing_url%22%3A%22%22%7D%7D; sensorsdata2015jssdkcrossmiddle_track_web=%7B%22distinct_id%22%3A%2210001%22%2C%22first_id%22%3A%221907bb7f36a991-01bbf1ac243d863-19525637-1764000-1907bb7f36b10ed%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfbG9naW5faWQiOiIxMDAwMSIsIiRpZGVudGl0eV9jb29raWVfaWQiOiIxOTA3YmI3ZjM2YTk5MS0wMWJiZjFhYzI0M2Q4NjMtMTk1MjU2MzctMTc2NDAwMC0xOTA3YmI3ZjM2YjEwZWQifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%2210001%22%7D%2C%22%24device_id%22%3A%221907bb7f36a991-01bbf1ac243d863-19525637-1764000-1907bb7f36b10ed%22%7D; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22197345925498b3-0d9f5bef6cca8d8-19525636-2073600-1973459254a4bf%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTk3MzQ1OTI1NDk4YjMtMGQ5ZjViZWY2Y2NhOGQ4LTE5NTI1NjM2LTIwNzM2MDAtMTk3MzQ1OTI1NGE0YmYifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%221904e4e47f9637-0dec8b9fa3daa3-19525637-1764000-1904e4e47fa725%22%7D")
                .post(bodyContent)
                .build();

        // 发送请求并获取响应
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected response code: " + response.code()+response.message());
        }
        String string = response.body().string();
        return string;
    }


    /**
     * 读取输入流的辅助方法
     */
    private static String readInputStream(java.io.InputStream inputStream) throws IOException {
        StringBuilder result = new StringBuilder();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            result.append(new String(buffer, 0, bytesRead));
        }
        return result.toString();
    }
}
