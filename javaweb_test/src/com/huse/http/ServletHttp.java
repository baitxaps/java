package com.huse.http;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class ServletHttp extends HttpServlet {
    // File → Settings → Editor → Inspections
    //search : Duplicated Code
    private void test1() throws IOException {
        Properties properties = new Properties();
        InputStream is0 = new FileInputStream("classes/db.properties"); //tomcat /bin
        properties.load(is0);

        String driverClassName = properties.getProperty("driverClassName");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println(driverClassName + url + username + password);
    }

    private void test2() throws IOException {
        Properties properties = new Properties();//webapps\manager\WEB-INF\classes
        InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/classes");
        // path: //tomcat/webapps/WEB-INF/classes/db.properties
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.getWriter().println("servlet Http Do doGet...");
        test3();

        ServletConfig config = this.getServletConfig();
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");
        System.out.println(username +"  " + password);
        //doPost(req,resp);

        // get all parameters
        Enumeration<String> names = config.getInitParameterNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            String value = config.getInitParameter(name);
            System.out.println(name + "  " +value);
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
        System.out.println(globalpassword + "  " + globalusername);
        names = config.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = config.getInitParameter(name);
            System.out.println(name + "  " + value);
        }

        // get the  file of  web program

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("servlet Http Do post...");
    }
}
//228


