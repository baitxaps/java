package cn.huse.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import cn.huse.domain.User;

public class PrivilegeFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)request;
		User existUser = (User) req.getSession().getAttribute("existUser");
		if(existUser == null) {
			// no login
			req.setAttribute("msg", "no login,no access!");
			req.getRequestDispatcher("/login/login_new.jsp").forward(req, response);
		}else {
			// has done login
			chain.doFilter(req, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}













