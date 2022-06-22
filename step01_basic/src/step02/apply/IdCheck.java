package step02.apply;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IdCheck
 */
@WebServlet("/idCheck")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IdCheck() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//		System.out.println("id: " + request.getParameter("id"));
		//		System.out.println("Pw: " + request.getParameter("pw"));

		System.out.println("GET");
		print(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		doGet(request, response);
		//		
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//		System.out.println("post_id: " + request.getParameter("id"));
		//		System.out.println("post_Pw: " + request.getParameter("pw"));
		System.out.println("POST");
		print(request, response);

	}

	protected void print(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
//		response.getWriter().append("id: ").append(id);
//		response.getWriter().append("\n");
//		response.getWriter().append("pw: ").append(pw);
		System.out.println("id: " + id );
		System.out.println("Pw: " + pw);
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>테스트 중입니다.</h2>");
		out.println("안녕하세요. "  + id + "님");
		out.println("</body>");
		out.println("</html>");
	}

}
