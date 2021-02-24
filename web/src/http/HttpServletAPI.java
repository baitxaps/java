package http;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class HttpServletAPI extends javax.servlet.http.HttpServlet {
    // File → Settings → Editor → Inspections
    // search : Duplicated Code

    @Override
    public void init() throws ServletException {
        this.getServletContext().setAttribute("name", "william");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("HttpServletAPI Do doGet...");
        String name = (String) this.getServletContext().getAttribute("name");
        System.out.println("name:" + name);

        test2();
        /*
        200:OK
        302:redirect
        304:search local cache data
        404:req  resource to return not exist
        500:server internal error

        重定向因为是从客户端发来的，所以只知道发到那个服务器，不知道发给那个项目，
        所以重定向的"/"表示"http:服务器ip:8080/"
        请求转发因为服务器内部自己转发，因此知道发给那个项目，
        所以请求转发的"/"表示"http:服务器ip:8080/项目名/"
        重定向没有"/"表示在当前目录，请求转发没有"/"表示相对于当前资源的相对路径
        */

        // redirect to new page
//      resp.setStatus(302);
//      resp.setHeader("Location", "/scope"); //or resp.sendRedirect("/scope");

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("5s to jump to next page");
        resp.setHeader("Refresh","5;url=/scope");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("HttpServletAPI Do post...");
        doGet(req, resp);
    }

    private void test1() throws IOException {
        Properties properties = new Properties();
        InputStream is0 = new FileInputStream("/classes/db.properties"); //tomcat /bin
        properties.load(is0);

        String driverClassName = properties.getProperty("driverClassName");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println(driverClassName + url + username + password);
    }

    private void test2() throws IOException {
        // db.properties 要放在 src根目录下
        Properties properties = new Properties();
        InputStream is = this.getServletContext().getResourceAsStream("WEB-INF/classes/db.properties");
        properties.load(is);

        String driverClassName = properties.getProperty("driverClassName");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println(driverClassName + url + username + password);
    }

    private void test3() throws IOException {
        Properties properties = new Properties();
        String path = this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
        System.out.println(path);
        InputStream is = new FileInputStream(path);
        properties.load(is);

        String driverClassName = properties.getProperty("driverClassName");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println(driverClassName + url + username + password);
    }

    private void getParameter() {
        ServletConfig config = this.getServletConfig();
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");
        System.out.println(username + "  " + password);
        //doPost(req,resp);

        // get all parameters
        Enumeration<String> names = config.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = config.getInitParameter(name);
            System.out.println(name + "  " + value);
        }

        //get servlet name
        String servletName = config.getServletName();
        System.out.println(servletName);

        // !!!
        //get MIME type
        ServletContext servletContext = this.getServletContext();
        String mimeType = servletContext.getMimeType("aa.txt");
        System.out.println(mimeType);

        //get the program of name
        String path = servletContext.getContextPath();
        System.out.println(path);

        //get global parameters
        String globalusername = servletContext.getInitParameter("username");
        String globalpassword = servletContext.getInitParameter("password");
        System.out.println(globalusername + "  " + globalpassword);
        names = config.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = config.getInitParameter(name);
            System.out.println(name + "  " + value);
        }
    }
}


/* warning
1.disconnected no supported authentication methods available(server sent: publickey)
or git did not exit cleanly (exit code 1)
or git did not exit cleanly (exit code 128)
多半是因为git和小乌龟有冲突。
2. 右键:小乌龟—settings->network->修改ssh client为git的ssh.exe
(setup path: Git->usr->bin->ssh.exe)
*/
