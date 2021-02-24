package cn.huse.weblistener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//ServletContextListener企业用途
//加载框架的配置文件：
//1.Spring框架提供了一个核心监听器ContextLoaderListener。
//2.定时任务调度：

public class MySeverletContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContextEvent to destroy");
	  //syso -> alt+/
	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContextEvent to Initialize");
	}

}
