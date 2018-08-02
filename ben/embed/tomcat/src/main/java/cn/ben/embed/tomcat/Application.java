package cn.ben.embed.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Server;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.startup.ContextConfig;
import org.apache.catalina.startup.Tomcat;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.tomcat.util.scan.StandardJarScanner;
import cn.ben.embed.tomcat.servlet.TestServlet;

import javax.servlet.ServletException;
import java.io.File;

/**
 * @TIME 2018/5/15 14:30
 * @User yangkun
 * @DESCRIPTION
 */
public class Application {

    public static void main(String[] args) throws Exception {
//        Application application = new Application();
//        application.polaris();
        tomcat1();
    }

    public static void tomcat1() throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.setBaseDir("e:/tmp/tomcat1");
        tomcat.getHost().setAutoDeploy(false);

        Server server = tomcat.getServer();
        server.setPort(8005);

        String contextPath = "/tom";
        StandardContext context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());
        tomcat.getHost().addChild(context);

        tomcat.addServlet(contextPath, "testServlet", new TestServlet());
        context.addServletMappingDecoded("/test", "testServlet");

        tomcat.start();
        server.await();
    }

    public static void my() throws LifecycleException {
        Tomcat tomcat = new Tomcat(); // 创建tomcat实例，用来启动tomcat
        StandardContext context = new StandardContext();
        context.setPath("/web");
        context.addLifecycleListener(new Tomcat.FixContextListener());
        tomcat.getHost().addChild(context);
        tomcat.addServlet("/web", "test", new TestServlet());
        context.addServletMappingDecoded("/test", "test");
//        tomcat.setHostname("localhost"); // 默认
//        tomcat.setPort(8888); //设置端口
//        tomcat.setBaseDir("/temp"); //tomcat存储自身信息的目录，比如日志等信息，根目录

//        Server server = tomcat.getServer();
//        server.setPort(8889);
//        Engine engine = tomcat.getEngine();
//        Host host = tomcat.getHost();

//        Service service = tomcat.getService();
//        service.setName("embed_tomcat");

//        Connector connect = new Connector();
//        Connector connect = new Connector("protocol");
//        connect.setPort(8080); //  set 一些参数
//        tomcat.setConnector(connect);

//        Connector connector = tomcat.getConnector();
//        connector.setPort(8887);
//        Context context = tomcat.addContext("/test", null);

//        tomcat.addServlet(context, "test", new TestServlet());
//        context.addServletMappingDecoded("/test", "test");

        tomcat.start();
        tomcat.getServer().await();
    }

    public static void copy() throws LifecycleException, ServletException {
        Tomcat tomcat = new Tomcat();//创建tomcat实例，用来启动tomcat
//        tomcat.setHostname("localhost");//设置主机名
//        tomcat.setPort(8080);//设置端口
//        tomcat.setBaseDir(".");//tomcat存储自身信息的目录，比如日志等信息，根目录

//        String DEFAULT_PROTOCOL = "org.apache.coyote.http11.Http11NioProtocol";
        Connector connector = new Connector();//设置协议，默认就是这个协议connector.setURIEncoding("UTF-8");//设置编码
        connector.setPort(8080);//设置端口
        tomcat.getService().addConnector(connector);

        Context ctx = tomcat.addContext("myapp", "");//网络访问路径

        tomcat.addServlet(ctx, "myServlet", new TestServlet()); //配置servlet

        ctx.addServletMappingDecoded("/messageServlet", "myServlet");//配置servlet映射路径


        StandardServer server = (StandardServer) tomcat.getServer();//添加监听器，不知何用
        AprLifecycleListener listener = new AprLifecycleListener();
        server.addLifecycleListener(listener);

        //设置appBase为项目所在目录
        tomcat.getHost().setAppBase(System.getProperty("user.dir") + File.separator + ".");

        //设置WEB-INF文件夹所在目录
        //该文件夹下包含web.xml
        //当访问localhost:端口号时，会默认访问该目录下的index.html/jsp页面
//        tomcat.addWebapp("", "resources");

        tomcat.start();//启动tomcat
        tomcat.getServer().await();//维持tomcat服务，否则tomcat一启动就会关闭
    }

    public void polaris() throws Exception {
        Tomcat tomcat = new Tomcat();

        //工作路径
        String resourceBase = java.net.URLDecoder.decode(this.getClass().getClass().getResource("/").getPath(), "UTF-8") + File.separator + "WebContent";
        File resDir = new File(resourceBase);
        String catalina_home = resDir.getCanonicalPath();
        String contextPath = "";
        String docBase = "";

        //设置工作目录
        tomcat.setHostname("0.0.0.0");
        //端口号
        tomcat.setPort(8080);

        //设置工作目录,其实没什么用,tomcat需要使用这个目录进行写一些东西
        tomcat.setBaseDir(catalina_home);

        //设置程序的目录信息和线程数
        tomcat.getHost().setAppBase(catalina_home);
        Http11NioProtocol protocol = (Http11NioProtocol) tomcat.getConnector().getProtocolHandler();

        // Add AprLifecycleListener
        StandardServer server = (StandardServer) tomcat.getServer();
        AprLifecycleListener listener = new AprLifecycleListener();
        server.addLifecycleListener(listener);

        //加载上下文
        StandardContext standardContext = new StandardContext();

        //RequestFirstFilter加载
//        FilterDef filterDef = new FilterDef();
//        filterDef.setFilter(new RequestFirstFilter());
//        filterDef.setFilterName("RequestFirstFilter");
//        standardContext.addFilterDef(filterDef);
//        FilterMap filterMap = new FilterMap();
//        filterMap.addURLPattern("/*");
//        filterMap.setFilterName("RequestFirstFilter");
//        standardContext.addFilterMap(filterMap);

        //其他参数加载
        standardContext.setPath(contextPath);//contextPath
        standardContext.setDocBase(docBase);//文件目录位置
        standardContext.addLifecycleListener(new Tomcat.DefaultWebXmlListener());
        standardContext.addLifecycleListener(new ContextConfig());

        //关闭jarScan
        StandardJarScanner jarScanner = new StandardJarScanner();
        jarScanner.setScanClassPath(false);
        jarScanner.setScanAllFiles(false);
        jarScanner.setScanAllDirectories(false);
        standardContext.setJarScanner(jarScanner);

        //保证已经配置好了。
        standardContext.addLifecycleListener(new Tomcat.FixContextListener());
        standardContext.setSessionCookieName("jsessionid");
        tomcat.getHost().addChild(standardContext);
        tomcat.start();
        tomcat.getServer().await();
    }
}
