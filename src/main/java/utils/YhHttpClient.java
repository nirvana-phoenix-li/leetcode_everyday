package utils;

import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.util.PublicSuffixMatcher;
import org.apache.http.conn.util.PublicSuffixMatcherLoader;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URL;

public class YhHttpClient {

    private static int socketTimeout = 15000;
    private static int connectTimeout = 15000;
    private static int connectionRequestTimeout = 15000;
    private static RequestConfig requestConfig = null;
    // 连接池相关参数
    private static int connMgrMaxTotal = 1000;
    private static int connMgrMaxPerRoute = 500;
    private static PoolingHttpClientConnectionManager connMgr = null;

    static {
        requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).setConnectionRequestTimeout(connectionRequestTimeout).build();
        connMgr = new PoolingHttpClientConnectionManager();
        connMgr.setDefaultMaxPerRoute(connMgrMaxPerRoute);
        connMgr.setMaxTotal(connMgrMaxTotal);
    }

    public static String sendHttpPostJson(String url, String json) {
        // 创建httpPost
        HttpPost httpPost = new HttpPost(url);
        try {
            // StringEntity stringEntity = new StringEntity(param, "UTF-8");
            // stringEntity.setContentType("application/json");
            // stringEntity.setContentEncoding("UTF-8");
            // stringEntity.setContentType("application/json");
            StringEntity stringEntity = new StringEntity(json, ContentType.create("application/json", "UTF-8"));
            httpPost.setEntity(stringEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return doHttp(httpPost);
    }

    @SneakyThrows
    private static String doHttp(HttpRequestBase httpRequestBase)  {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String responseContent = null;

        try {
            // 创建默认的httpClient实例.
            String scheme = httpRequestBase.getURI().getScheme();
            if (scheme.equalsIgnoreCase("https")) {
                PublicSuffixMatcher publicSuffixMatcher = PublicSuffixMatcherLoader.load(new URL(httpRequestBase.getURI().toString()));
                DefaultHostnameVerifier hostnameVerifier = new DefaultHostnameVerifier(publicSuffixMatcher);
                httpClient = HttpClients.custom().disableAutomaticRetries().setSSLHostnameVerifier(hostnameVerifier).setConnectionManager(connMgr).build();
                //httpClient = HttpClients.custom().setSSLHostnameVerifier(hostnameVerifier).build();
            } else if (scheme.equalsIgnoreCase("http")) {
                httpClient = HttpClients.custom().setConnectionManager(connMgr).build();
                //httpClient = HttpClients.createDefault();
            } else {
                throw new IllegalArgumentException("url的scheme错误，必须是http或者https！ ");
            }
            httpRequestBase.setConfig(requestConfig);
            // 执行请求
            long start = System.currentTimeMillis();
            response = httpClient.execute(httpRequestBase);
            // 如果这里有必要获取的是其他资料都可以在这里进行逻辑处理
            responseContent = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.printf("http执行时间：{}ms,入参为：{},出参为：{}", System.currentTimeMillis() - start, JSON.toJSONString(httpRequestBase), responseContent);
            return responseContent;
        } catch (Exception e) {
            System.out.printf("http调用失败，失败原因：{}", e.getMessage(), e);
            throw new Exception(e.getMessage());
        } finally {
            try {
                // 关闭连接,释放资源
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                System.out.printf("http response.close()失败，失败原因：{}", e.getMessage(), e);
            }
        }
    }
}




