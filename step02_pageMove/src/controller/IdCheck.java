package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IdCheck
 */
@WebServlet("/check")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public IdCheck() {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    // id 값이 busan이라고 한다면 -> /valid 매핑되어 있는 servlet 화면 이동
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String id = request.getParameter("uname");
		String pw = request.getParameter("psw");
		

		if("busan".equals(id)) {
			// /valid 매핑되어 있는 servlet 화면 이동
			
			// 
//			response.sendRedirect("valid");
			request.getRequestDispatcher("valid").forward(request, response);
		}else {
			response.sendRedirect("invalid");
//			request.getRequestDispatcher("invalid").forward(request, response);
		}
	}

}