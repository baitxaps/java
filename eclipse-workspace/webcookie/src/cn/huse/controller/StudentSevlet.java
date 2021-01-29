package cn.huse.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.huse.model.Student;
import cn.huse.model.StudentModel;

//快捷键 :Shift+Alt+s 
//选择:generater getter and setter
//格式化代码的快捷键是:Ctrl+Shift+F
//在当前行之上插入一行快捷键: Ctrl + Shift + Enter
//在当前行之下插入一行快捷键: Shift + Enter
//可以用ctrl+shift+M/Ctrl+Shift+o/Ctrl+1导入相应的包. 其中Ctrl+1只是快速修复。
//将光标放到某一行，按住Ctrl+Alt+Down，即可以在下面快速复制一行，
//按住Ctrl+Alt+Up，即可以在上面快速复制一行。
//注释jsp: ctrl+shift+C
//277
public class StudentSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 1.调用Java类处理数据
			StudentModel studentModel = new StudentModel();
			List<Student> list = studentModel.findAll();
			// 2.显示到JSP页面
			request.setAttribute("list", list);
			request.getRequestDispatcher("/jsp/list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
