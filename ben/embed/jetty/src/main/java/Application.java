import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @TIME 2018/7/19 15:06
 * @User yangkun
 * @DESCRIPTION
 */
public class Application {
    public static void main(String[] args) throws Exception {
        warServer();
    }

    /**
     * 简单server 访问 资源下文件 html
     */
    public static void simple() throws Exception {
        Server server = new Server(8080); // 服务器
        ResourceHandler handler = new ResourceHandler(); // 处理器
        handler.setResourceBase("d:/jetty");
        server.setHandler(handler);
//        ServerConnector connector = new ServerConnector(server); // 连接
//        connector.setPort(8080);
//        server.addConnector(connector);
        server.start();
    }

    public static void warServer() throws Exception {
        Server server = new Server(8080);
        WebAppContext context = new WebAppContext();
        context.setWar("D:/IDEAWORK/web1/target/web1.war");
        server.setHandler(context);
        server.start();
    }

}
