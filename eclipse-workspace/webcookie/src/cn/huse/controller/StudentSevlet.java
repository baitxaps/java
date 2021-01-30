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

public class StudentSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			StudentModel stuModel = new StudentModel();
			List<Student> list = stuModel.findAll();
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/jsp/list.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
