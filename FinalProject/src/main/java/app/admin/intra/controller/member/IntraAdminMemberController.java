package app.admin.intra.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/intra/member")
public class IntraAdminMemberController {
	@RequestMapping("memberList")
	public String memberList() {
		return "thymeleaf/admin/intra/member/member_list";
	}
	@RequestMapping("memberView")
	public String memberView() {
		return "thymeleaf/admin/intra/member/member_view";
	}
	@RequestMapping("memberWrite")
	public String memberWrite() {
		return "thymeleaf/admin/intra/member/member_write";
	}
	@RequestMapping("memberModify")
	public String memberModify() {
		return "thymeleaf/admin/intra/member/member_modify";
	}
	@RequestMapping("memberDelete")
	public String memberDelete() {
		return "thymeleaf/admin/intra/member/member_delete";
	}
}
