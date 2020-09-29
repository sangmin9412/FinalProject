package app.admin.matching.controller.match;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.admin.matching.command.MatchCommand;
import app.admin.matching.service.MatchService;

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
	@Autowired
	MatchService matchService;
	@RequestMapping(value = "matchWritePro", method = RequestMethod.POST)
	public String matchWritePro(@Validated MatchCommand matchCommand, BindingResult result, HttpServletRequest request) throws Exception{
		/*
		 * if (result.hasErrors()) { System.out.println("에러"); return
		 * "thymeleaf/admin/matching/match/match_write"; }
		 */
		String location=matchService.matchWrite(matchCommand,request);
		return location;
	}
	@RequestMapping("matchModify")
	public String matchModify() {
		return "thymeleaf/admin/matching/match/match_modify";
	}
}
