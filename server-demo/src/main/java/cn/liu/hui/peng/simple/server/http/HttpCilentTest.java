package cn.liu.hui.peng.simple.server.http;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class HttpCilentTest {


    public static void main(String[] args) {
        fun1();
    }


    private static void fun1() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("http://www.baidu.com");

        try {
            CloseableHttpResponse response = httpClient.execute(get);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println(responseEntity.getContentLength());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
