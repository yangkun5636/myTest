package cn.ben.embed.tomcat;

/**
 * @TIME 2018/8/1 16:33
 * @User yangkun
 * @DESCRIPTION
 */
public class TomcatServerTest {
    public static void main(String[] args) {
        TomcatServer server = TomcatServer.getInstance();
        server.start();
    }

}