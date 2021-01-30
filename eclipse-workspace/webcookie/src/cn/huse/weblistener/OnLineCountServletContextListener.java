package cn.huse.weblistener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OnLineCountServletContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// initialize the count is 0
		// save to servletContext
		// the scope of servlet share to  request    
		arg0.getServletContext().setAttribute("count", 0);
	}

}











