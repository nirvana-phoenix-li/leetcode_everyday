package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import utils.YhHttpClient;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TestHttp {
    public static void main(String[] args) {
        String indexQuantificationUrl = "http://10.1.52.177:55570/pic_similarity";
        JSONObject body = new JSONObject();
        body.put("pic_1", "https://image.yonghuivip.com/images/comment/23a03016-0e07-4f8a-a866-03536824b74f-80e80bec801cdee048f7f9090bb2522dbbfc78db.png");
        body.put("pic_2", "https://image.yonghuivip.com/images/comment/49d10e37-8abb-4f1b-b992-1487b76de5a7-17e83e53f1c331757d122a4e275ec6d774e0e2b3.png");
//        body.put("pic_2", "https://image.yonghuivip.com/images/comment/96fd6e57-3ccc-47b8-a345-a614b5aaf8a6-7a59bfe9c8c39fcbf8d7d0dcb67ae1717a483aae.png");
        String jsonString = body.toJSONString();

        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        ArrayList<Integer> integers = new ArrayList<>(hashSet);

        int isTure=0;
        int isFalse=0;
        for (int i = 0; i < 100; i++) {
            long currented = System.currentTimeMillis();
            String result = YhHttpClient.sendHttpPostJson(indexQuantificationUrl, jsonString);

            JSONObject metaJson = JSON.parseObject(result);
            Integer answer = metaJson.getInteger("result");

            int k = answer == 1 ? isTure++ : isFalse++;
            System.out.println(System.currentTimeMillis()-currented);
            System.out.println(isTure);
            System.out.println(isFalse);
        }


    }
}
