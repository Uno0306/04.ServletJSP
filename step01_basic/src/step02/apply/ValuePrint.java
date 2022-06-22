package step02.apply;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValuePrint
 */
//@WebServlet(asyncSupported = true, name = "print", urlPatterns = { "/views/print" })
@WebServlet("/print")
public class ValuePrint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValuePrint() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("GET");
    	request.setCharacterEncoding("UTF-8");
//    	response.setCharacterEncoding("UTF-8");
//    	response.setContentType("text/html; charset=UTF-8");
    	
//    	PrintWriter out = response.getWriter();
    	
//    	String[] likes = request.getParameterValues("like");
//    	if(likes == null) {
//    		out.println("선택한 좋아하는 것이 없습니다.");
//    	}else {
//    		for (String like : likes) {
//    			out.println(like+"<br>");
//    		}
//    	}
    	
    	System.out.println(request.getQueryString());
    	System.out.println(URLDecoder.decode(request.getQueryString(), "UTF-8"));
    	
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
		
		
		ServletInputStream input = request.getInputStream();
		System.out.println(input);	// org.apache.catalina.connector.CoyoteInputStream@6a0ad4b1
		int length = request.getContentLength();
		byte[] data = new byte[length];
		input.readLine(data, 0, length);
		// post방식으로 넘어온 request 객체의 body정보
		String str = new String(data);
		System.out.println(URLDecoder.decode(str, "UTF-8"));
		
		
		
//		PrintWriter out = response.getWriter();
//		
//		String[] likes = request.getParameterValues("like");
//		if(likes == null) {
//			out.println("선택한 좋아하는 것이 없습니다.");
//		}else {
//			for (String like : likes) {
//				out.println(like+"<br>");
//			}
//		}
	}

}
