package cn.ben.embed.tomcat;

import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import cn.ben.embed.tomcat.servlet.TestServlet;

/**
 * @TIME 2018/7/19 13:06
 * @User yangkun
 * @DESCRIPTION
 */
public class EmbedTomcatHttp {
    static final int port = 8080;
    static final String docBase = "D:/tmp/tomcat";

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.setBaseDir(docBase);
        tomcat.getHost().setAutoDeploy(false);

        String contextPath = "/book1";
        StandardContext context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());
        tomcat.getHost().addChild(context);

        tomcat.addServlet(contextPath, "homeServlet", new TestServlet());
        context.addServletMappingDecoded("/home", "homeServlet");
        tomcat.start();
        tomcat.getServer().await();
    }
}
