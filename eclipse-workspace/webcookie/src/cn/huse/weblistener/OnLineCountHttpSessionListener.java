package cn.huse.weblistener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnLineCountHttpSessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		// onLine
		HttpSession session = se.getSession();
		System.out.println(session.getId()+"onLine...");
		Integer count = (Integer) session.getServletContext().getAttribute("count");
		count ++;
		// save to servletContext
		session.getServletContext().setAttribute("count", count);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		//ofLine
		HttpSession session = se.getSession();
		System.out.println(session.getId()+"ofLine...");
		Integer count = (Integer) session.getServletContext().getAttribute("count");
		count --;
		// save to servletContext
		session.getServletContext().setAttribute("count", count);
	}

}
