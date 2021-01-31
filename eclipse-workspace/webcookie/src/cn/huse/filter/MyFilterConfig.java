package cn.huse.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilterConfig implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

	}

	public void init(FilterConfig config) throws ServletException {
		String filterName = config.getFilterName();
		System.out.println(filterName);
		
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		System.out.println("name: " + username + " psw: " +password);
	}

}









