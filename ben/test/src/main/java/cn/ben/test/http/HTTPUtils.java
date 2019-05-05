package cn.ben.test.http;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Http请求
 *
 * @author mszhou
 */
public class HTTPUtils {
    private static final int TIMEOUT = 45000;
    private static final String ENCODING = "UTF-8";

    /**
     * 创建HTTP连接
     *
     * @param url              地址
     * @param method           方法
     * @param headerParameters 头信息
     * @param body             请求内容
     */
    private static HttpURLConnection createConnection(String url, String method, Map<String, String> headerParameters, String body) throws Exception {
        URL Url = new URL(url);
        trustAllHttpsCertificates();
        HttpURLConnection httpConnection = (HttpURLConnection) Url.openConnection();
        // 设置请求时间
        httpConnection.setConnectTimeout(TIMEOUT);
        // 设置 header
        if (headerParameters != null) {
            for (String key : headerParameters.keySet()) {
                httpConnection.setRequestProperty(key, headerParameters.get(key));
            }
        }
        httpConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + ENCODING);

        // 设置请求方法
        httpConnection.setRequestMethod(method);
        httpConnection.setDoOutput(true);
        httpConnection.setDoInput(true);
        // 写query数据流
        if (!(body == null || "".equals(body.trim()))) {
            OutputStream writer = httpConnection.getOutputStream();
            try {
                writer.write(body.getBytes(ENCODING));
            } finally {
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
            }
        }

        // 请求结果
        int responseCode = httpConnection.getResponseCode();
        if (responseCode != 200) {
            throw new Exception(responseCode + ":" + inputStream2String(httpConnection.getErrorStream(), ENCODING));
        }
        return httpConnection;
    }

    /**
     * POST请求
     *
     * @param address          请求地址
     * @param headerParameters 参数
     */
    public static String post(String address, Map<String, String> headerParameters, String body) throws Exception {

        return proxyHttpRequest(address, "POST", null, getRequestBody(headerParameters));
    }

    /**
     * GET请求
     */
    public static String get(String address, Map<String, String> headerParameters, String body) throws Exception {
        return proxyHttpRequest(address + "?" + getRequestBody(headerParameters), "GET", null, null);
    }

    /**
     * 读取网络文件
     */
    public static String getFile(String address, Map<String, String> headerParameters, File file) throws Exception {
        String result;
        HttpURLConnection httpConnection = null;
        try {
            httpConnection = createConnection(address, "POST", null, getRequestBody(headerParameters));
            result = readInputStream(httpConnection.getInputStream(), file);
        } finally {
            if (httpConnection != null) {
                httpConnection.disconnect();
            }
        }
        return result;
    }

    public static byte[] getFileByte(String address, Map<String, String> headerParameters) throws Exception {
        byte[] result = null;
        HttpURLConnection httpConnection = null;
        try {
            httpConnection = createConnection(address, "POST", null, getRequestBody(headerParameters));
            result = readInputStreamToByte(httpConnection.getInputStream());
        } finally {
            if (httpConnection != null) {
                httpConnection.disconnect();
            }

        }

        return result;
    }

    /**
     * 读取文件流
     *
     * @param in
     */
    public static String readInputStream(InputStream in, File file) throws Exception {
        FileOutputStream out = null;
        ByteArrayOutputStream output = null;
        try {
            output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                output.write(buffer, 0, len);
            }
            out = new FileOutputStream(file);
            out.write(output.toByteArray());
        } finally {
            if (output != null) {
                output.close();
            }
            if (out != null) {
                out.close();
            }
        }
        return "success";
    }

    public static byte[] readInputStreamToByte(InputStream in) throws Exception {
        byte[] byteFile;
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                output.write(buffer, 0, len);
            }
            byteFile = output.toByteArray();
        }
        return byteFile;
    }

    /**
     * HTTP请求
     *
     * @param address          地址
     * @param method           方法
     * @param headerParameters 头信息
     * @param body             请求内容
     */
    public static String proxyHttpRequest(String address, String method, Map<String, String> headerParameters, String body) throws Exception {
        String result;
        HttpURLConnection httpConnection = null;
        try {
            httpConnection = createConnection(address, method, headerParameters, body);
            String encoding = "UTF-8";
            if (httpConnection.getContentType() != null && httpConnection.getContentType().contains("charset=")) {
                encoding = httpConnection.getContentType().substring(httpConnection.getContentType().indexOf("charset=") + 8);
            }
            result = inputStream2String(httpConnection.getInputStream(), encoding);
            // logger.info("HTTPproxy response: {},{}", address,
            // result.toString());

        } finally {
            if (httpConnection != null) {
                httpConnection.disconnect();
            }
        }
        return result;
    }

    /**
     * 将参数化为 body
     */
    public static String getRequestBody(Map<String, String> params) {
        return getRequestBody(params, true);
    }

    /**
     * 将参数化为 body
     *
     * @param params
     * @return
     */
    public static String getRequestBody(Map<String, String> params, boolean urlEncode) {
        StringBuilder body = new StringBuilder();
        for (String key : params.keySet()) {
            String value = params.get(key);

            if (urlEncode) {
                try {
                    body.append(key).append("=").append(URLEncoder.encode(value, ENCODING)).append("&");
                } catch (UnsupportedEncodingException e) {
                    // e.printStackTrace();
                }
            } else {
                body.append(key).append("=").append(value).append("&");
            }
        }
        if (body.length() == 0) {
            return "";
        }
        return body.substring(0, body.length() - 1);
    }

    /**
     * 读取inputStream 到 string
     */
    private static String inputStream2String(InputStream input, String encoding) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, encoding));
        StringBuilder result = new StringBuilder();
        String temp;
        while ((temp = reader.readLine()) != null) {
            result.append(temp);
        }
        return result.toString();

    }


    /**
     * 设置 https 请求
     */
    private static void trustAllHttpsCertificates() throws Exception {
        HttpsURLConnection.setDefaultHostnameVerifier((str, session) -> true);
        TrustManager[] trustAllCerts = new TrustManager[1];
        TrustManager tm = new MiTm();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }


    /**
     * 设置 https 请求证书
     */
    static class MiTm implements TrustManager, X509TrustManager {
        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        @Override
        public void checkServerTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
        }

        @Override
        public void checkClientTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
        }


    }

    //====================================================================
    //============================= 测试调用   ============================
    //====================================================================
    public static void main(String[] args) {

        try {
            String get = HttpUtil.get("https://xuan236.com/");

            String httpRequest = HttpRequest.get("https://xuan236.com/").execute().body();

            //请求地址(我这里测试使用淘宝提供的手机号码信息查询的接口)
//            String address = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm";
            String address = "https://xuan236.com/";

            //请求参数
            Map<String, String> params = new HashMap<>();
            //这是该接口需要的参数
            params.put("tel", "13777777777");

            // 调用 get 请求
//            String res = get(address, params, null);
            String res = proxyHttpRequest(address, "GET", null, null);
            //打印返回参数
            System.out.println(res);

            //截取
            res = res.substring(res.indexOf("{"));
            //转JSON
            JSONObject result = JSONObject.parseObject(res);

            //打印
            System.out.println(result.toString());

        } catch (Exception e) {
            // TODO 异常
            e.printStackTrace();
        }

    }

}