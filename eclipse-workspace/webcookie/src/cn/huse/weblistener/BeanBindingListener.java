package cn.huse.weblistener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

//保存在Session域中的Java类可以有多种状态：
//绑定到session中,从session中解除绑定；
//随session对象持久化到一个存储设备中（钝化）；随session对象从一个存储设备中恢复（活化）。

//Servlet对方中定义了两个特殊的监听的接口来帮助Java类了解自己在Session域中的状态：
//HttpSessionBindingListener接口
//HttpSessionActivationListener接口，
//实现这两个接口的类不需要在web.xml中进行配置

public class BeanBindingListener implements HttpSessionBindingListener{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("beanListener and session to bind");
	}

	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("beanListener and session to unbind");
	}
}
