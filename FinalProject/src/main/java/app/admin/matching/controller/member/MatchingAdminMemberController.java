package app.admin.matching.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.admin.matching.command.MemberAddCommand;
import app.admin.matching.command.MemberCommand;
import app.admin.matching.service.MemberAddWriteService;
import app.admin.matching.service.MemberJoinService;

@Controller
@RequestMapping("/admin/matching/member")
public class MatchingAdminMemberController {
	@Autowired
	MemberJoinService memberJoinService;
	@Autowired
	MemberAddWriteService memberAddWriteService;

	@RequestMapping("memberList")
	public String memberList() {
		return "thymeleaf/admin/matching/member/member_list";
	}

	@RequestMapping("memberView")
	public String memberView() {
		return "thymeleaf/admin/matching/member/member_view";
	}

	@RequestMapping("memberWrite")
	public String memberWrite(MemberCommand memberCommand) {
		return "thymeleaf/admin/matching/member/member_write";
	}

	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public String memberJoin(@Valid MemberCommand memberCommand, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "thymeleaf/admin/matching/member/member_write";
		}

		Integer i = memberJoinService.insertMember(memberCommand, model);
		if (i == null) {
			return "thymeleaf/admin/matching/member/member_write";
		}
		return "redirect:/";

	}

	@RequestMapping("memberAdd")
	public String memberAdd() {
		return "thymeleaf/admin/matching/member/member_add_write";
	}

	@RequestMapping(value = "memberAddWrite", method = RequestMethod.POST)
	public String memberAddWrite(MemberAddCommand memberAddCommand, HttpServletRequest request) throws Exception {
		Integer i = memberAddWriteService.insertMemberAdd(memberAddCommand, request);
		if (i == null) {
			return "thymeleaf/admin/matching/member/member_add_write";
		}
		return "redirect:/";

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
