 package util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DoLogin implements Filter{
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//获取session，request，response对象
		HttpServletRequest servletRequest=(HttpServletRequest)request;
		HttpServletResponse servletResponse=(HttpServletResponse)response;
		HttpSession session=servletRequest.getSession();
		//获取请求URI
		String path=servletRequest.getRequestURI();
		//从Session中获取管理员
		
		String adminName=(String) session.getAttribute("name");
		
		String password=(String)session.getAttribute("password");
		
		if(path.indexOf("/index.jsp")>-1)
		{
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		if(password==null||"".equals(password))
			servletResponse.sendRedirect("/StudentInfo/index.jsp");
		else{
			chain.doFilter(request, response);
		}	
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
