package app.controller.main;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.admin.matching.command.LoginCommand;
import app.admin.matching.service.LoginService;

@Controller
@RequestMapping(value = "/")
public class LoginController {
	@Autowired
	LoginService loginService; 
	
	@RequestMapping("login")
	public String login(LoginCommand loginCommand) {
		return "thymeleaf/admin/matching/member/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login1(@Validated LoginCommand loginCommand,
			BindingResult result, HttpSession session,
			HttpServletResponse response, Model model) throws Exception {
		if (result.hasErrors()) {
			 return "thymeleaf/admin/matching/member/login";
		}
		String location=loginService.execute(loginCommand,session,response,model);
		return location;
	}
}
