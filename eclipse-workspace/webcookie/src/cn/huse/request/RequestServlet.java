package cn.huse.request;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet {

	   // get form info
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqForm(request);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
