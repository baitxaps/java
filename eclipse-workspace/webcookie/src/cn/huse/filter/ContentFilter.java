package cn.huse.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//Filter称为过滤器，它是Servlet技术中最实用的技术，web开发人员通过Filter技术，
//对web服务器所管理的资源（JSP，Servlet，静态图片或静态html文件）进行拦截，
//从而实现一些特殊的功能。
//Filter就是过滤从客户端向服务器发送的请求

//FilterChain过滤器链：在一个web应用中，可以开发编写多个Filter，
//这些Filter组合起来称为是一个过滤器链。
//Web服务器根据Filter在web.xml文件中的注册顺序（mapping的配置顺序）
//决定先调用那个Filter。依次调用后面的过滤器，如果没有下一个过滤器，调用目标资源

//Filter的生命周期：Filter的创建和销毁是由web服务器负责。
//Web应用程序启动的时候，web服务器创建Filter的实例对象。
//并调用其init方法进行初始化（filter对象只会创建一次，init方法也只会执行一次）。
//每次filter进行拦截的时候，都会执行doFilter的方法。
//当服务器关闭的时候，应用从服务器中移除的时候，服务器会销毁Filter对象



public class ContentFilter implements Filter{

	public void destroy() {
		System.out.println("ContentFilter destroy...");
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("ContentFilter exec...");
		
		//过滤放行
		chain.doFilter(req,resp);
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("ContentFilter init...");
	}

}
