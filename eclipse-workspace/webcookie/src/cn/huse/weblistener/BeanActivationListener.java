package cn.huse.weblistener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

//配置完成session的序列化和反序列化
//Context标签可以配置在：
//tomcat/conf/context.xml :所有tomcat下虚拟主机和虚拟目录下的工程都会序列化session
//tomcat/conf/Catalina/localhost/context.xml:localhost虚拟主机下的所有项目会序列化session
//工程/META-INF/context.xml	:当前工程才会序列化session。

//<Context>
//<Manager className="org.apache.catalina.session.PersistentManager" maxIdleSwap="1">
//	<Store className="org.apache.catalina.session.FileStore" directory="itheima"/>
//</Manager>
//</Context>


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








