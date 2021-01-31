package cn.huse.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilterConfig implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("my filter exec...");
		//放行
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig config) throws ServletException {
		String filterName = config.getFilterName();
		System.out.println(filterName);

		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		System.out.println("name: " + username + " psw: " + password);

		// get all parameters
		Enumeration<String> parameters = config.getInitParameterNames();
		while (parameters.hasMoreElements()) {
			String name = parameters.nextElement();
			String value = config.getInitParameter(name);
			System.out.println(name + "  " + value);
		}
	}

}
