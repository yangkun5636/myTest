package cn.ben.test.http;

import javax.net.ssl.HttpsURLConnection;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author yangkun
 */
public class HttpsRequest {

    public static void request() throws Exception {
        URL reqURL = new URL("https://www.oracle.com/cn/sun/"); //创建URL对象
        HttpsURLConnection httpsConn = (HttpsURLConnection) reqURL.openConnection();

    /*下面这段代码实现向Web页面发送数据，实现与网页的交互访问
        httpsConn.setDoOutput(true);
        OutputStreamWriter out = new OutputStreamWriter(huc.getOutputStream(), "8859_1");
        out.write( "……" );
        out.flush();
        out.close();
    */

        //取得该连接的输入流，以读取响应内容
        InputStreamReader insr = new InputStreamReader(httpsConn.getInputStream());

        //读取服务器的响应内容并显示
        int respInt = insr.read();
        while (respInt != -1) {
            System.out.print((char) respInt);
            respInt = insr.read();
        }

    }

    public static void main(String[] args) throws Exception {
        request();
    }
}
