package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.EmpDAO;

/**
 * Servlet implementation class EmpController
 */
@WebServlet("/emp")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpController() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 메소드 정의
		/* step01
		 * emp 사번 -> ename 사원의 이름을 반환받으려고 합니다!
		 * String ename = EmpDAO.getName(empno);
		 * 
		 * step02 : 페이지 이동(forward, redirect)
		 * ename 있다고 한다면? -> View.jsp 이름값을 전달(?)
		 * ename 없다고 한다면? -> View.jsp "사원의 이름이 없습니다." 문자열을 전달(?)
		 * 만약에 SQLException이 발생한다면? -> failView.jsp로 이동(?)
		 * 
		 */

		// session 생성
		HttpSession session = request.getSession();

		// empno가 빈 값이거나 null일 경우
		String empnoStr = request.getParameter("empno");
		if(empnoStr == null || "".equals(empnoStr)) {
			empnoStr = "0";
		}	// empnoStr를 0으로 만들어 줌
		
		
		int empno = Integer.parseInt(empnoStr);	// getParameter는 String으로 받아서 int로 형변환 해준다.
		String ename = "";

		try {
			ename = EmpDAO.getName(empno);	// empno를 통해 ename을 전달해주는 EmpDAO의 getName 실행
			System.out.println(ename);
			if(ename != null && !("".equals(ename))) {
				System.out.println(ename);
				// session
//				session.setAttribute("ename", ename);
//				response.sendRedirect("view.jsp");
				
				// request
				request.setAttribute("ename", ename);
				request.getRequestDispatcher("view.jsp").forward(request, response);
				
			} else {
				System.out.println("이름이 없음");
				response.sendRedirect("invalidView.jsp");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("failView.jsp");
		} 
		
	}

}
