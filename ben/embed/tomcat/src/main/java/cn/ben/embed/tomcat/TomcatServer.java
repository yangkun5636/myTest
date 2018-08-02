package cn.ben.embed.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.Server;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.ContextConfig;
import org.apache.catalina.startup.Tomcat;

/**
 * @TIME 2018/8/1 13:15
 * @User yangkun
 * @DESCRIPTION
 */
public class TomcatServer {
    private Tomcat tomcat;

    private TomcatServer() {
    }

    public static TomcatServer getInstance() {
        return Singletone.tomcatServer;
    }

    /**
     * 启动tomcat
     */
    public void start() {
        try {
            if (tomcat != null) {
                tomcat.stop();
                tomcat = null;
            }
            init();

            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

    private void init() {
        tomcat = new Tomcat();
        tomcat.setHostname("0.0.0.0");
        tomcat.setPort(8080);
        tomcat.setBaseDir("WebContent");
//        tomcat.getHost().setAppBase("WebContent");

//        Server server = tomcat.getServer();

        StandardContext context = new StandardContext();
        context.setPath("");
        context.addLifecycleListener(new Tomcat.FixContextListener());
//        context.addLifecycleListener(new ContextConfig());
//        context.setDocBase("WebContent");

        tomcat.getHost().addChild(context);

    }

    private static class Singletone {
        private static final TomcatServer tomcatServer = new TomcatServer();
    }
}
