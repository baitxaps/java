package cn.huse.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//过滤器的相关配置
//<url-pattern>的配置
//完全路径匹配：以/开始   比如/aaa  /aaa/bbb
//目录匹配	：以/开始 以*结束  比如/*  /aaa/*  /aaa/bbb/*
//扩展名匹配：不能以/开始 以*开始 比如*.jsp  *.do   *.action

//<servlet-name>的配置,专门以Servlet的配置的名称拦截Servlet。

//<dispatcher>的配置,默认的情况下过滤器会拦截请求。如果进行转发（需要拦截这次转发）。
//dispatcher的取值
//REQUEST:默认值,默认过滤器拦截的就是请求。!!!
//FORWARD:转发!!!
//INCLUDE:页面包含的时候进行拦截
//ERROR	:页面出现全局错误页面跳转的时候进行拦截


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
