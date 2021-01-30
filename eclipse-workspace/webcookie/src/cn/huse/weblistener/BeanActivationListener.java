package cn.huse.weblistener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class BeanActivationListener implements HttpSessionActivationListener,Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void sessionDidActivate(HttpSessionEvent arg0) {
		System.out.println("beanActivation 钝化了。。。");
	}

	public void sessionWillPassivate(HttpSessionEvent arg0) {
		System.out.println("beanActivation 活化了。。。");
	}
	
}








