package filter;

import domain.AdminDomain;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/** 
 * @description 认证Filter 
 */
public class AuthenticationFilter implements Filter{

	public void destroy() {
				
	}
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpServletResponse res=(HttpServletResponse) arg1;
		HttpSession session=req.getSession();
		
		AdminDomain admin=(AdminDomain) session.getAttribute("user");
		
		String path=req.getRequestURI();
		
		if(path.indexOf("index.jsp")>-1||path.indexOf("login.do")>-1||path.endsWith("css")||path.endsWith("js")||path.endsWith("jpg")){
			chain.doFilter(req, res);
			return;
		}
		if(admin==null||"".equals(admin)){
			res.sendRedirect("index.jsp");
		}else{
			chain.doFilter(req, res);
		}
		
	}
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
