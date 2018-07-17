import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import servlet.TestServlet;

/**
 * @TIME 2018/5/15 14:30
 * @User yangkun
 * @DESCRIPTION
 */
public class Application {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8888);
        tomcat.setBaseDir("/temp");

        Server server = tomcat.getServer();
        server.setPort(8889);
        Engine engine = tomcat.getEngine();
        Host host = tomcat.getHost();

        Service service = tomcat.getService();
        service.setName("embed_tomcat");

        Connector connector = tomcat.getConnector();
        Context context = tomcat.addContext("", "/");
        tomcat.addServlet("", "", new TestServlet());
        context.addServletMappingDecoded("/test", "test");

        tomcat.start();
        server.await();
    }
}
