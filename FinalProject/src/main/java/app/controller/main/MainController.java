package app.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String home() {
		return "thymeleaf/index";
	}
	@RequestMapping("/buttons")
	public String t1() {
		return "thymeleaf/test/buttons";
	}
	@RequestMapping("/cards")
	public String t2() {
		return "thymeleaf/test/cards";
	}
	@RequestMapping("/colors")
	public String t3() {
		return "thymeleaf/test/utilities-color";
	}
	@RequestMapping("/borders")
	public String t4() {
		return "thymeleaf/test/utilities-border";
	}
	@RequestMapping("/animations")
	public String t5() {
		return "thymeleaf/test/utilities-animation";
	}
	@RequestMapping("/other")
	public String t6() {
		return "thymeleaf/test/utilities-other";
	}
	@RequestMapping("/login")
	public String t7() {
		return "thymeleaf/test/login";
	}
	@RequestMapping("/register")
	public String t8() {
		return "thymeleaf/test/register";
	}
	@RequestMapping("/forgotPass")
	public String t9() {
		return "thymeleaf/test/forgot-password";
	}
	@RequestMapping("/blank")
	public String t10() {
		return "thymeleaf/test/blank";
	}
	@RequestMapping("/charts")
	public String t11() {
		return "thymeleaf/test/charts";
	}
	@RequestMapping("/tables")
	public String t12() {
		return "thymeleaf/test/tables";
	}
	@RequestMapping("/forms")
	public String t13() {
		return "thymeleaf/test/forms";
	}
	
}