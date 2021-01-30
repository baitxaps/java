package cn.huse.weblistener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

//ServletContextAttributeListener
//监听ServletContext对象中的属性变更（属性添加，移除，替换）的监听器
// 
//HttpSessionAttributeListener
//监听HttpSession对象中的属性变更（属性添加，移除，替换）的监听器
// 
//ServletRequestAttributeListener
//监听ServletRequest对象中的属性变更（属性添加，移除，替换）的监听器

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("httpsession attributed to add");
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("httpsession attributed to remove");
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("httpsession attributed to replace");
	}

}
