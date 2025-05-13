package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import utils.YhHttpClient;

public class TestHttp {
    public static void main(String[] args) {
        String indexQuantificationUrl = "http://10.1.52.177:55570/pic_similarity";
        JSONObject body = new JSONObject();
        body.put("pic_1", "https://image.yonghuivip.com/images/comment/5da82102-9312-4149-80f4-0b55fc6369c2-2c5b4c568c44a113d11c203fb247474126bfedae.png");
        body.put("pic_2", "https://image.yonghuivip.com/images/comment/5da82102-9312-4149-80f4-0b55fc6369c2-2c5b4c568c44a113d11c203fb247474126bfedae.png");
//        body.put("pic_2", "https://image.yonghuivip.com/images/comment/96fd6e57-3ccc-47b8-a345-a614b5aaf8a6-7a59bfe9c8c39fcbf8d7d0dcb67ae1717a483aae.png");
        String jsonString = body.toJSONString();
        long currented = System.currentTimeMillis();
        String result = YhHttpClient.sendHttpPostJson(indexQuantificationUrl, jsonString);

        JSONObject metaJson = JSON.parseObject(result);
        Integer answer = metaJson.getInteger("result");

        System.out.println(System.currentTimeMillis()-currented);
        System.out.println(result);
        System.out.println(answer);

    }
}
