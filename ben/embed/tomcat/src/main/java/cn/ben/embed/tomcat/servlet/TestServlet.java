package cn.ben.embed.tomcat.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @TIME 2018/5/15 14:39
 * @User yangkun
 * @DESCRIPTION
 */
public class TestServlet extends HttpServlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init servlet");
        super.init(servletConfig);
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("servlet config");
        return super.getServletConfig();
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet service");
        super.service(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy servlet");
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>Test</h1>");
        resp.getWriter().print("中文get");
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        resp.getWriter().print("中文post");
        resp.getWriter().close();
    }
}
