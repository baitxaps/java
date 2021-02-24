package cn.huse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.huse.domain.User;
import cn.huse.model.UserModel;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			// 接收数据:
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			// 封装数据:
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			// 处理数据:
			UserModel userModel = new UserModel();
			User existUser = userModel.login(user);
			// 根据处理结果页面跳转:
			if(existUser == null){
				// 登录失败
				request.setAttribute("msg", "用户名或密码错误!");
				request.getRequestDispatcher("/login/login_new.jsp").forward(request, response);
			}else{
				// 登录成功
				request.getSession().setAttribute("existUser", existUser);
				response.sendRedirect(request.getContextPath()+"/jsp/success_new.jsp");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
