package app.admin.matching.controller.member;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.admin.matching.command.MemberLoginCommand;
import app.admin.matching.service.MemberLoginService;

@Controller
@RequestMapping(value = "/")
public class MemberLoginController {
	@Autowired
	MemberLoginService memberLoginService; 
	
	@RequestMapping("login")
	public String login(MemberLoginCommand memberLoginCommand) {
		return "thymeleaf/admin/matching/member/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login1(@Validated MemberLoginCommand memberLoginCommand,
			BindingResult result, HttpSession session,
			HttpServletResponse response, Model model) throws Exception {
		if (result.hasErrors()) {
			 return "thymeleaf/admin/matching/member/login";
		}
		String location=memberLoginService.execute(memberLoginCommand,session,response,model);
		return location;
	}
}
