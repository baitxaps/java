package servlet;
import javax.servlet.*;
import java.io.IOException;

public class HuseServlet implements Servlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("hello Servlet...");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init....");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
