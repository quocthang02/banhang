package poly.edu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SideAuthenticationlnterceptor {
	@Autowired
	private HttpSession session;
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("pre handle of request " + request.getRequestURI());
		if (session.getAttribute("username") != null) {
			return true;
		}
		session.setAttribute("redirect-uri", request.getRequestURI());
	    response.sendRedirect("/login");
	return false;
	}
}
