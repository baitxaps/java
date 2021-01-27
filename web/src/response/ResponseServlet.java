package response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;

@WebServlet(name = "ResponseServlet")
public class ResponseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reqForm(request);
        return;
    }

    private void reqForm(HttpServletRequest request) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username + " password: " + password);

        String[] hobby = request.getParameterValues("hobby");
        String info = request.getParameter("info");

        Map<String, String[]> map = request.getParameterMap();
        for(String key:map.keySet()){
            String[] value = map.get(key);
            System.out.println(key + "   " + Arrays.toString(value));
        }

        // decode encode
        String name = request.getParameter("username");
        String encode = URLEncoder.encode(name,"ISO-8859-1");
        String decode = URLDecoder.decode(encode,"UTF-8");
        System.out.println("name" + decode);
        //or
        String value = new String(name.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println("name " + value);
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











