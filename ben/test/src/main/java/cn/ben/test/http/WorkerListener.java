package cn.ben.test.http;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.net.ssl.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Application Lifecycle Listener implementation class WorkerListener
 * @author yangkun
 */
public class WorkerListener implements ServletContextListener {


    private ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
    private ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) ctx.getBean("taskExecutor");

    private static final int SERVER_PORT = 443;

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub

        try {
            String serverKeyStoreFile = "c:\\Windows\\System32\\mykeystore.jks";
            String serverKeyStorePwd = "changeit";
            String catServerKeyPwd = "changeit";
            String serverTrustKeyStoreFile = "c:\\RCS\\DB\\config\\certs\\truststore.jks";
            String serverTrustKeyStorePwd = "changeit";

            KeyStore serverKeyStore = KeyStore.getInstance("JKS");
            serverKeyStore.load(new FileInputStream(serverKeyStoreFile), serverKeyStorePwd.toCharArray());

            KeyStore serverTrustKeyStore = KeyStore.getInstance("JKS");
            serverTrustKeyStore.load(new FileInputStream(serverTrustKeyStoreFile), serverTrustKeyStorePwd.toCharArray());

            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(serverKeyStore, catServerKeyPwd.toCharArray());

            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(serverTrustKeyStore);

            SSLContext sslContext = SSLContext.getInstance("TLSv1");
            //第二个参数TrustManager[] 是认证管理器，在需要双向认证时使用
            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(SERVER_PORT);
            //sslServerSocket.setNeedClientAuth(true);

            while (true) {
                SSLSocket s = (SSLSocket) sslServerSocket.accept();
                Accepter accepter = new Accepter(s);
                accepter.service();

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    class Accepter {
        private SSLSocket socket;

        public Accepter(SSLSocket socket) {
            this.socket = socket;
            System.out.println("连接到服务器的用户:" + socket);
        }

        public void service() {
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    //这里编写处理业务代码
                    synchronized (this) {
                        try {
                            // 第一阶段: 打开输入流
                            InputStream is = socket.getInputStream();

                            System.out.println("客户端发送的请求信息: >>>>>>>>>>>>>>>>>>>>>>>>>");
                            // 读取第一行, 请求地址
                            String line = readLine(is, 0);
                            //打印请求行
                            System.out.print(line);
                            // < Method > < URL > < HTTP Version > <\r\n>  取的是URL部分
                            String line2 = line;
                            String httpversion = line2.substring(line2.length() - 10).trim();
                            httpversion = URLDecoder.decode(httpversion, "UTF-8");//反编码 URL 地址

                            String resource = line.substring(line.indexOf('/'), line.lastIndexOf('/') - 5);
                            //获得请求的资源的地址
                            resource = URLDecoder.decode(resource, "UTF-8");//反编码 URL 地址
                            String method = new StringTokenizer(line).nextElement().toString();// 获取请求方法, GET 或者 POST
                            int contentLength = 0;//如果为POST方法，则会有消息体长度

                            // 读取所有浏览器发送过来的请求参数头部信息
                            do {
                                line = readLine(is, 0);
                                //如果有Content-Length消息头时取出
                                if (line.startsWith("Content-Length")) {
                                    contentLength = Integer.parseInt(line.split(":")[1].trim());
                                }
                                //打印请求部信息
                                System.out.print(line);
                                //如果遇到了一个单独的回车换行，则表示请求头结束
                            } while (!line.equals("\r\n"));
                            //如果是POST请求，则有请求体
                            if ("POST".equalsIgnoreCase(method)) {
                                //注，这里只是简单的处理表单提交的参数，而对于上传文件这里是不能这样处理的，
                                //因为上传的文件时消息体不只是一行，会有多行消息体
                                System.out.print(readLine(is, contentLength));
                                System.out.println();
                            }
                            System.out.println("客户端发送的请求信息结束 <<<<<<<<<<<<<<<<<<<<<<<<<<");
                            System.out.println("用户请求的资源是(uri):" + resource);
                            System.out.println("请求的类型是: " + method);
                            System.out.println("请求的http版本是: " + httpversion);
                            System.out.println("连接到服务器的用户:" + socket.getRemoteSocketAddress());

                        } catch (Exception e) {
                            // replace with other code
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
/*   这里我们自己模拟读取一行，因为如果使用API中的BufferedReader时，它是读取到一个回车换行后
             才返回，否则如果没有读取，则一直阻塞，这就导致如果为POST请求时，表单中的元素会以消息体传送，
             这时，消息体最末按标准是没有回车换行的，如果此时还使用BufferedReader来读时，则POST提交
             时会阻塞。如果是POST提交时我们按照消息体的长度Content-Length来截取消息体，这样就不会阻塞 */

    private String readLine(InputStream is, int contentLe) throws IOException {
        ArrayList lineByteList = new ArrayList();
        byte readByte;
        int total = 0;
        if (contentLe != 0) {
            do {
                readByte = (byte) is.read();
                lineByteList.add(Byte.valueOf(readByte));
                total++;
            } while (total < contentLe);//消息体读还未读完
        } else {
            do {
                readByte = (byte) is.read();
                lineByteList.add(Byte.valueOf(readByte));
            } while (readByte != 10);
        }

        byte[] tmpByteArr = new byte[lineByteList.size()];
        for (int i = 0; i < lineByteList.size(); i++) {
            tmpByteArr[i] = ((Byte) lineByteList.get(i)).byteValue();
        }
        lineByteList.clear();

        String tmpStr = new String(tmpByteArr, "UTF-8");
/*       http请求的header中有一个Referer属性，这个属性的意思就是如果当前请求是从别的页面链接过
		  来的，那个属性就是那个页面的url，如果请求的url是直接从浏览器地址栏输入的就没有这个值。得
		  到这个值可以实现很多有用的功能，例如防盗链，记录访问来源以及记住刚才访问的链接等。另外，浏
		  览器发送这个Referer链接时好像固定用UTF-8编码的，所以在GBK下出现乱码，我们在这里纠正一下 */

        if (tmpStr.startsWith("Referer")) {//如果有Referer头时，使用UTF-8编码
            tmpStr = new String(tmpByteArr, "UTF-8");
        }
        return tmpStr;
    }
}