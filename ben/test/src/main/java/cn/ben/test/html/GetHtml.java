package cn.ben.test.html;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;

public class GetHtml {
    public static void main(String[] args) throws Exception {
        sendUrl("https://mp.weixin.qq.com/s?__biz=MzI1NDQ3MjQxNA==&mid=100000436&idx=1&sn=eb2fa33ec66dcec31c62cf8332ede6f4&chksm=69c5fb055eb27213b58dce2b550c8282cf172d1b3f9c83f00263d99325a933e2add6da30385b&mpshare=1&scene=23&srcid=1019Dk8NKnVHhuRtT6PPxDfU#rd");
    }

    public static String sendUrl(String url) throws Exception {
        URL urll = new URL(url);
        URLConnection connection = urll.openConnection();
        Object content = connection.getContent();
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = inputStream.readLine()) != null) {
            builder.append(line);
        }

        String document = builder.toString();
        document.replaceAll(""," ");
        System.out.println(builder);

        return null;

    }
}
