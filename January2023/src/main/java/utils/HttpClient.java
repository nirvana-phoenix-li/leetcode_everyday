package utils;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

/**
 * Created by iBo on 1/25.
 */
@Slf4j
public class HttpClient {

    //JSON
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    //URLENCODED
    public static final MediaType URLENCODED = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    //XML SOAP1.2协议
    public static final MediaType XML = MediaType.parse("application/soap+xml; charset=utf-8");
    //request对象
    private static final OkHttpClient okHttpClient = new OkHttpClient();

    /**
     * Http GET 请求
     *
     * @param url
     * @return
     * @throws IOException
     */
    public Response get(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = okHttpClient.newCall(request).execute();
        return response;
    }

    public Response get(String url, Map<String, String> header) throws IOException {
        Request.Builder requestBuilder = new Request.Builder().url(url);
        if (header != null) {
            for (Map.Entry<String, String> headEntry : header.entrySet()) {
                requestBuilder.addHeader(headEntry.getKey(), headEntry.getValue());
            }
        }
        Request request = requestBuilder.build();
        Response response = okHttpClient.newCall(request).execute();
        return response;
    }

    /**
     * Http POST 请求
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public Response postByJson(String url, String json) throws IOException {
        return postByJson(url, null, json);
    }

    /**
     * Http POST 请求
     *
     * @param url
     * @param head
     * @param json
     * @return
     * @throws IOException
     */
    public Response postByJson(String url, Map<String, String> head, String json) throws IOException {
        return post(url, head, json, JSON);
    }

    /**
     * Http POST 请求
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public Response postByEncode(String url, String json) throws IOException {
        return postByEncode(url, null, json);
    }

    /**
     * Http POST 请求
     *
     * @param url
     * @param head
     * @param json
     * @return
     * @throws IOException
     */
    public Response postByEncode(String url, Map<String, String> head, String json) throws IOException {
        return post(url, head, json, URLENCODED);
    }

    /**
     * Http POST 请求
     *
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    public Response postByForm(String url, Map<String, String> params) throws IOException {
        return postForm(url, null, params);
    }

    /**
     * Http POST 请求
     *
     * @param url
     * @param head
     * @param xml
     * @return
     * @throws IOException
     */
    public Response postByXml(String url, Map<String, String> head, String xml) throws IOException {
        return post(url, head, xml, XML);
    }

    /**
     * Http DELETE 请求
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public Response delete(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).delete(body).build();
        Response response = okHttpClient.newCall(request).execute();
        return response;
    }

    /**
     * Http PUT 请求
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public Response put(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).put(body).build();
        Response response = okHttpClient.newCall(request).execute();
        return response;
    }

    /**
     * Http POST 请求
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public Response post(String url, Map<String, String> head, String json, MediaType type) throws IOException {
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(url);
        // region 设置请求参数
        if (json != null) {
            RequestBody body = RequestBody.create(type, json);
            requestBuilder.post(body);
        }
        // region 设置请求头
        if (head != null) {
            for (Map.Entry<String, String> headEntry : head.entrySet()) {
                requestBuilder.addHeader(headEntry.getKey(), headEntry.getValue());
            }
        }
        Request request = requestBuilder.build();
        Response response = okHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            return response;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * form请求
     *
     * @param url
     * @param heads
     * @param params
     * @return
     * @throws IOException
     */
    public Response postForm(String url, Map<String, String> heads, Map<String, String> params) throws IOException {
        Request.Builder requestBuilder = new Request.Builder().url(url);
        // region 设置请求参数
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                formBodyBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        // region 设置请求头
        if (heads != null) {
            for (Map.Entry<String, String> headEntry : heads.entrySet()) {
                requestBuilder.addHeader(headEntry.getKey(), headEntry.getValue());
            }
        }
        Request request = requestBuilder.post(formBodyBuilder.build()).build();
        Response response = okHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            return response;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    public Response uploadImage(String url, String key, byte[] bytes, String fileName,
                                Map<String, String> params) throws IOException {
        // 设置文件以及文件上传类型封装
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), bytes);
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart(key, fileName, requestBody);
        // 文件上传的请求体封装
        if (params != null) {
            for (String mKey : params.keySet()) {
                builder.addFormDataPart(mKey, params.get(mKey));
            }
        }
        MultipartBody multipartBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(multipartBody)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            return response;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    public String uploadFile(String url, byte[] fileBytes, String fileName) throws IOException {
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), fileBytes);
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart(fileName, fileName, requestBody);
        MultipartBody multipartBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(multipartBody)
                .build();
        Response response = okHttpClient.newCall(request).execute();
//        while (!response.isSuccessful()){
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            response = okHttpClient.newCall(request).execute();
//            System.out.println("sb循环呢");
//        }
        String body = response.body().string();
        response.close();
        if (response.isSuccessful()) {
            return body;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }
}
