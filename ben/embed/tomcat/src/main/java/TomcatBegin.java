import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.HostConfig;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.startup.VersionLoggerListener;
import org.apache.catalina.valves.AccessLogValve;
import org.apache.tomcat.util.descriptor.web.ErrorPage;
import servlet.TestServlet;

import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @TIME 2018/7/19 11:29
 * @User yangkun
 * @DESCRIPTION
 */
public class TomcatBegin {
    public static void main(String[] args) throws ServletException, LifecycleException, IOException {

        Map<String, String> map = System.getenv();

        File catalinaHome = new File(map.getOrDefault("TOMCAT_HOME", "/opt/tomcat/"));
        int port = Integer.valueOf(map.getOrDefault("TOMCAT_PORT", "8080"));

        Tomcat tomcat = new Tomcat();

        tomcat.setBaseDir(catalinaHome.getAbsolutePath());
        tomcat.getServer().addLifecycleListener(new VersionLoggerListener()); // nice to have
        tomcat.getHost().addLifecycleListener(new HostConfig());
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        tomcat.getService().addConnector(connector);

        StandardContext context = new StandardContext();
        context.setPath("/web");
        context.addLifecycleListener(new Tomcat.FixContextListener());
        tomcat.getHost().addChild(context);
        tomcat.addServlet("/web","testServlet",new TestServlet());
        context.addServletMappingDecoded("/test","testServlet");

        connector.setPort(port);
        connector.setURIEncoding("UTF-8");

        tomcat.setConnector(connector);
        // tomcat.getHost().setAutoDeploy(false);
        AccessLogValve access = new AccessLogValve();
        access.setPattern("%h %l %u %t \"%r\" %s %b");
        tomcat.getEngine().getPipeline().addValve(access);

        // INIT mime-type
        tomcat.getHost().addLifecycleListener(new LifecycleListener() {

            public void lifecycleEvent(LifecycleEvent event) {
                if (event.getType().equals(Lifecycle.AFTER_INIT_EVENT)) {
                    StandardHost host = (StandardHost) event.getSource();
                    host.setContextClass(StandardMimeContext.class.getName());
                }
            }
        });

        // tomcat.getServer().setParentClassLoader(Application.class.getClassLoader());

        tomcat.start();
        tomcat.getServer().await();
    }

    public static class StandardMimeContext extends StandardContext {
        public StandardMimeContext() {
            // INIT !!!! MIME-TYPE
            Tomcat.initWebappDefaults(this);
            //
            this.addLifecycleListener(new Tomcat.FixContextListener());
            ErrorPage page = new ErrorPage();
            page.setLocation("/error");
            this.addErrorPage(page);
        }
    }
}
