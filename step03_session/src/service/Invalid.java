package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Invalid
 */
@WebServlet(name = "invalid", urlPatterns = { "/invalid" })
public class Invalid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Invalid() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    // SessionFinal 로그아웃 버튼 클릭했을 때 -> 현재의 Servlet에서 세션 무효화
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("lecture"));
		session.invalidate();
		session = null;
//		System.out.println(session.getAttribute("lecture"));
		
		response.sendRedirect("login.html");
	}

}
