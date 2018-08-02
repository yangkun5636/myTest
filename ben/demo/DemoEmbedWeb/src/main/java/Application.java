import cn.ben.embed.tomcat.TomcatServer;

/**
 * @TIME 2018/8/1 10:24
 * @User yangkun
 * @DESCRIPTION
 */
public class Application {
    public static void main(String[] args) throws Exception {
        TomcatServer server = TomcatServer.getInstance();
        server.start();
    }
}
