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
    private void test1() throws IOException {
        Properties properties = new Properties();
        InputStream is0 = new FileInputStream("classes/db.properties"); //tomcat /bin
        InputStream is1 = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
       // path: //tomcat/webapps/WEB-INF/classes/db.proterties
        String path = this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
        properties.load(is0);

        String driverClassName = properties.getProperty("driverClassName");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println(driverClassName);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // resp.getWriter().println("servlet Http Do doGet...");

        ServletConfig config = this.getServletConfig();
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");
        System.out.println(username +"  " + password);
        //doPost(req,resp);

        // get all Paramters
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

        //get global paramters
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
        test1();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("servlet Http Do post...");
    }
}
//228

//#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
//        #parse("File Header.java")
//@javax.servlet.annotation.WebServlet(name = "${Entity_Name}")
//public class ${Class_Name} extends javax.servlet.http.HttpServlet {
//protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
//
//        }
//
//protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
//
//        }
//        }


//#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
//        #parse("File Header.java")
//@javax.servlet.annotation.WebServlet(name = "${Entity_Name}", urlPatterns="/${Entity_Name}")
//public class ${Class_Name} extends javax.servlet.http.HttpServlet {
//protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//        }
//
//protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
//        request.setCharacterEncoding("utf-8");
//        }
//        }
