package cn.huse.weblistener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;


//ServletRequest对象的创建和销毁:
//创建:从客户端向服务器发送一次请求，服务器就会创建request对象。
//销毁:服务器对这次请求作出了响应之后，request对象就销毁了
//问题：
//1.访问HTML页面是否创建请求对象	：会
//2.访问JSP页面是否创建请求对象		：会
//3.访问Servlet是否创建请求对象	：会

public class MyServletRequestListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("requestDestroyed");
	}

	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("requestInitialized");
	}

}
