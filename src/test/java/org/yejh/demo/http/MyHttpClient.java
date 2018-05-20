package org.yejh.demo.http;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class MyHttpClient {
    private static Logger logger = Logger.getLogger(MyHttpClient.class);

    public static String doHttpPost(String reqStr, String url, String contentType) {
        InputStream is = null;
        try {
            URLConnection urlConnection = new URL(url).openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setUseCaches(false);

            urlConnection.setConnectTimeout(30000);// 连接主机的超时时间（单位：毫秒）
            urlConnection.setReadTimeout(30000);// 从主机读取数据的超时时间（单位：毫秒）
            urlConnection.setRequestProperty("Content-length", String.valueOf(reqStr.getBytes().length));

            if (contentType != null) {
                urlConnection.setRequestProperty("Content-Type", contentType);
            }

            logger.info("请求接口地址: " + url + ", 请求数据: " + reqStr);

            OutputStreamWriter osw = new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8");
            osw.write(reqStr);
            osw.flush();
            osw.close();
            is = urlConnection.getInputStream();
            byte[] bis = IOUtils.toByteArray(is);
            String respStr = new String(bis, "UTF-8");
            logger.info("请求接口地址: " + url + ", 返回数据: " + respStr);
            return respStr;
        } catch (Exception e) {
            logger.error("请求接口地址: " + url + ", 异常: " + e.getMessage(), e);
            return null;
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception e) {
                logger.error("关闭URL链接: " + url + ", 异常: " + e.getMessage(), e);
                return null;
            }
        }
    }

    public static String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            // 打开和URL之间的连接
            URLConnection urlConnection = new URL(url).openConnection();
            // 设置请求属性
            urlConnection.setRequestProperty("accept", "*/*");
            urlConnection.setRequestProperty("connection", "Keep-Alive");
            urlConnection.setRequestProperty("Content-Type", "UTF-8");
            urlConnection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            urlConnection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = urlConnection.getHeaderFields();
            // 遍历所有的响应头字段
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                logger.info("HttpClientHelper-sendGet： " + entry.getKey() + "--->" + entry.getValue());
            }
            // BufferedReader输入流读取URL的响应
            in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.error("发送GET请求出现异常! " + e.getMessage(), e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                logger.error("关闭URL链接: " + url + ", 异常: " + e.getMessage(), e);
            }
        }
        return result;
    }
}
