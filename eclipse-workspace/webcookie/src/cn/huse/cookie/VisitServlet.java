package cn.huse.cookie;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.huse.utils.CookieUtils;
//tomcat 2.5 ¹æ·¶
public class VisitServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		Cookie cookie = CookieUtils.findCookie(cookies,"lastVisit");
		if(cookie == null) {
			//
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println("<h1>hello,welcome to page!</h1>");
		}else {
			String value = cookie.getValue();
			response.setContentType("text/html;charset=UTF-8");
			//String decode = URLDecoder.decode(value,"UTF-8");
			response.getWriter().println("<h1>hello,you the last visited of time:"+value +" </h1>");
			//response.getWriter().append(decode).println("<h1>hello,you the last visited of time:"+value +" </h1>");
		}
		
		
		Date d = new Date();
		// save to Cookie
		//Cookie c = new Cookie("lastVisit", d.toLocaleString());
		Cookie c = new Cookie("lastVisit",URLEncoder.encode( d.toLocaleString()));
		
		c.setPath("/webcooks");
		// valid time  1 hour
		c.setMaxAge(60*60);
		
		// write to browse
		response.addCookie(c);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
//243












