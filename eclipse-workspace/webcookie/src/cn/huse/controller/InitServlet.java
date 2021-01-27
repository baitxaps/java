package cn.huse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 鍒濆鍖栫殑Servlet
 * * 灏嗚繖涓猄ervlet閰嶇疆鎴愬惎鍔ㄦ椂鍔犺浇
 */
public class InitServlet extends HttpServlet {
	@Override
	/**
	 * 鍒濆鍖栫殑鏂规硶:
	 */
	public void init() throws ServletException {
		// 鍒濆涓�涓�间负0銆�
		int count = 0;
		// 灏嗚繖涓�煎瓨鍏ュ埌ServletContext鍩熶腑銆�
		this.getServletContext().setAttribute("count", count);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
