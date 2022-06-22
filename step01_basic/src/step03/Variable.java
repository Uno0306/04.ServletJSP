package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Variable
 */
@WebServlet(name = "var", urlPatterns = { "/var" })
public class Variable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Variable() {
        super();
    }

    String msg = "";
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // 프로젝트/var?msg=""
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int number = 0;
//		String msg = request.getParameter("msg");
		msg = request.getParameter("msg");
		
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		
		out.println("<html>");
			out.println("<head>");
				out.println("Variable Test");
			out.println("</head>");
			out.println("<body>");
				out.println("<h2>Result</h2>");
				while (number++ < 10) {
					out.print(msg + ": " + number + "<br/>");
					out.flush();
					System.out.println(msg + ": " + number );
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
