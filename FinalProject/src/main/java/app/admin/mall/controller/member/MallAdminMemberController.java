package app.admin.mall.controller.member;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.admin.matching.command.MemberCommand;
import app.admin.matching.service.MemberJoinService;
import app.admin.matching.service.MemberListService;

@Controller
@RequestMapping("/admin/mall/member")
public class MallAdminMemberController {
	@Autowired
	MemberJoinService memberJoinService;
	@Autowired
	MemberListService memberListService;

	@RequestMapping("memberList")
	public String memberList(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model)
			throws Exception {
		memberListService.memberList(model, page, 1);
		return "thymeleaf/admin/mall/member/member_list";
	}

	@RequestMapping("memberView")
	public String memberView() {
		return "thymeleaf/admin/mall/member/member_view";
	}

	@RequestMapping("memberWrite")
	public String memberWrite(MemberCommand memberCommand) {
		return "thymeleaf/admin/mall/member/member_write";
	}

	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public String memberJoin(@Valid MemberCommand memberCommand, BindingResult result, Model model) throws Exception {

		if (result.hasErrors()) {
			return "thymeleaf/admin/mall/member/member_write";
		}

		Integer i = memberJoinService.insertMember(memberCommand, model);
		if (i == null) {
			return "thymeleaf/admin/mall/member/member_write";
		}

		return "redirect:/";
	}

	@RequestMapping("memberModify")
	public String memberModify() {
		return "thymeleaf/admin/mall/member/member_modify";
	}

	@RequestMapping("memberDelete")
	public String memberDelete() {
		return "thymeleaf/admin/mall/member/member_delete";
	}

}