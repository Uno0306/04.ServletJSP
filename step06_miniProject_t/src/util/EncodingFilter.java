package util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
//@WebFilter(filterName = "guestbook.do", urlPatterns = { "/guestbook.do" })
public class EncodingFilter implements Filter {
	String env;
	
	/**
	 * Default constructor. 
	 */
	public EncodingFilter() {
		System.out.println("필터 객체 생성");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		System.out.println("필터 객체 init");
		env = config.getInitParameter("charset");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("before: 필터 적용 전");

		
		request.setCharacterEncoding(env);
		chain.doFilter(request, response);
		System.out.println("after: 필터 적용 후");
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {    	
		System.out.println("필터 객체 해제");
	}

}
