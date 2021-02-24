package cn.huse.weblistener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


//HttpSession创建和销毁
//创建：
//服务器端第一次调用getSession()方法时候。
//销毁：
//非正常关闭服务器（正常关闭服务器session会被序列化）。
//Session过期（默认过期时间30分钟）。
//手动调用session.invalidate()方法。

//问题
//访问HTML是否创建Session		：不会
//访问JSP是否创建Session		：会
//访问Servlet是否创建Session	：不会（默认没有调用getSession方法）


public class MyHttpSessionListener implements HttpSessionListener 
{

	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("sessionCreated");
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed");
	}

}
