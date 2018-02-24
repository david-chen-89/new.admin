package news.admin.contr;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import news.admin.comm.Constants.Session;
import news.admin.comm.Constants.Url;
import news.admin.svc.AccountService;

@Controller
public class LoginController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private HttpSession httpSession;

	@RequestMapping(value = { "/", "/admin" })
	public String admin() {
		if (httpSession.getAttribute(Session.USER_NAME) == null) {
			return Url.LOGIN;
		} else {
			return Url.HOME;
		}
	}

	@RequestMapping("/logout")
	public String logout() {
		httpSession.setAttribute(Session.USER_NAME, null);
		return Url.LOGIN;
	}

	@PostMapping("/login_action")
	public String login(@RequestParam("user_name") String username, @RequestParam("password") String password) {
		if (accountService.valid(username, password)) {
			httpSession.setAttribute("username", username);
			return Url.HOME;
		} else {
			return Url.LOGIN;
		}
	}
}
