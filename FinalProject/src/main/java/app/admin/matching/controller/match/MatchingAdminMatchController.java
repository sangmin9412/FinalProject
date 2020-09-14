package app.admin.matching.controller.match;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/matching/match")
public class MatchingAdminMatchController {
	@RequestMapping("matchList")
	public String matchList() {
		return "thymeleaf/admin/matching/match/match_list";
	}
	@RequestMapping("matchView")
	public String matchView() {
		return "thymeleaf/admin/matching/match/match_view";
	}
	@RequestMapping("matchWrite")
	public String matchWrite() {
		return "thymeleaf/admin/matching/match/match_write";
	}
	@RequestMapping("matchModify")
	public String matchModify() {
		return "thymeleaf/admin/matching/match/match_modify";
	}
}
