package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

/**
 * Servlet implementation class Final
 */
@WebServlet(name = "final", urlPatterns = { "/final" })
public class Final extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Final() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	// Client에 있는 Cookie 정보 획득 - 해당 서비스에서 발생시킨 쿠키 정보에 한해서만 획득
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("final servlet");
    	// myId, myAge, myName 으로 지정되어 있는 모든  쿠키 출럭	
    	Cookie[] cookies = request.getCookies();
 
    	for (Cookie cookie : cookies) {
			System.out.println("쿠키1 : " + cookie.getName());
			System.out.println("쿠키2 : " + cookie.getValue());
			response.getWriter().print("name : " + cookie.getName() + "<br/>");
			response.getWriter().print("value : " + cookie.getValue() + "<br/>");
			cookie.setMaxAge(0);
		}
    }

}
