package news.admin.intcp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private HttpSession httpSession;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String path = request.getServletPath();
		if (httpSession.getAttribute("username") == null) {
			if (!("/".equals(path) || "/login_action".equalsIgnoreCase(path))) {
				response.sendRedirect("/");
			}
		}
		return true;
	}
}
