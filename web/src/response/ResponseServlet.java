package response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResponseServlet")
public class ResponseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reqForm(request);
        return;
    }

    // get form info
    private void reqForm(HttpServletRequest request) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username + "password: " + password);
    }

    // get request info
    private void reqTest1(HttpServletRequest request) throws IOException {
        //testUrl: http://192.168.0.106:8080/resp?id=1&name=rhc
        String method = request.getMethod();
        String ip = request.getRemoteAddr();
        String parameters = request.getQueryString();
        String url = request.getRequestURI();
        String uri = request.getRequestURI();
        String browsetype = request.getHeader("User-Agent");

        System.out.println("method=" + method);
        System.out.println("ip=" + ip);
        System.out.println("parameters=" + parameters);
        System.out.println("url=" + url);
        System.out.println("uri=" + uri);
        System.out.println("user-Agent=" + browsetype);
    }

    private void bytesTest1(HttpServletResponse response) throws IOException {
//        response.setHeader("Content_Type","text/html;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().println("中国");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("中国");
    }

    private void bytesTest0(HttpServletResponse response) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        outputStream.write("中国".getBytes("UTF-8"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}











