package scope;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ScopeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        resp.getWriter().println("ScopeServlet Do doGet...");
        String name = (String) this.getServletContext().getAttribute("name");
        System.out.println("name:" + name);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        resp.getWriter().println("ScopeServlet Do post...");
        doGet(req,resp);
    }
}
