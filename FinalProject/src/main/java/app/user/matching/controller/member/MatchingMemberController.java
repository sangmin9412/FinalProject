package app.user.matching.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mypage/matching")
public class MatchingMemberController {
	@RequestMapping("/")
	public String home() {
		return "thymeleaf/matching/mypage/index";
	}
	@RequestMapping("memberAdd")
	public String memberAdd() {
		return "thymeleaf/matching/mypage/member_add_write";
	}
}
