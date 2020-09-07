package app.admin.matching.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/matching")
public class MatchingAdminMainController {
	@RequestMapping("/")
	public String home() {
		return "thymeleaf/admin/matching/index";
	}
	
}
