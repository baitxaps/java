package cn.huse.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import cn.huse.request.MyHttpServletRequest;

public class GenericEncodingFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest reqest, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 在过滤器中增加reqest对像，并将增强后的对像传递给Servlet;
		HttpServletRequest req = (HttpServletRequest) reqest;
		//增强req
		
		MyHttpServletRequest myReq = new MyHttpServletRequest(req);
		chain.doFilter(myReq, resp);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}
}












