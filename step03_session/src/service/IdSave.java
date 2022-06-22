package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.codegen.CachedIndexEntry;

/**
 * Servlet implementation class IdSave
 */
@WebServlet(name = "save", urlPatterns = { "/save" })
public class IdSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdSave() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("save servlet");
		
		// step01 cookie
		Cookie cookie3 = new Cookie("myName", "busan");
		cookie3.setMaxAge(60 * 60 * 24);
		response.addCookie(cookie3);
		
		
		// 화면으로 돌려준다 가정
		response.sendRedirect("final");
	}

}
