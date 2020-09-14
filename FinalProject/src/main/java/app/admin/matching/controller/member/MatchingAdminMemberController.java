package app.admin.matching.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/matching/member")
public class MatchingAdminMemberController {
	@RequestMapping("memberList")
	public String memberList() {
		return "thymeleaf/admin/matching/member/member_list";
	}
	@RequestMapping("memberView")
	public String memberView() {
		return "thymeleaf/admin/matching/member/member_view";
	}
	@RequestMapping("memberWrite")
	public String memberWrite() {
		return "thymeleaf/admin/matching/member/member_write";
	}
	@RequestMapping("memberModify")
	public String memberModify() {
		return "thymeleaf/admin/matching/member/member_modify";
	}
	@RequestMapping("memberDelete")
	public String memberDelete() {
		return "thymeleaf/admin/matching/member/member_delete";
	}
}
