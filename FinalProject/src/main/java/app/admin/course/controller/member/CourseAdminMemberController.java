package app.admin.course.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/course/member")
public class CourseAdminMemberController {
	@RequestMapping("memberList")
	public String memberList() {
		return "thymeleaf/admin/course/member/member_list";
	}
	@RequestMapping("memberView")
	public String memberView() {
		return "thymeleaf/admin/course/member/member_view";
	}
	@RequestMapping("memberWrite")
	public String memberWrite() {
		return "thymeleaf/admin/course/member/member_write";
	}
	@RequestMapping("memberModify")
	public String memberModify() {
		return "thymeleaf/admin/course/member/member_modify";
	}
	@RequestMapping("memberDelete")
	public String memberDelete() {
		return "thymeleaf/admin/course/member/member_delete";
	}
}
