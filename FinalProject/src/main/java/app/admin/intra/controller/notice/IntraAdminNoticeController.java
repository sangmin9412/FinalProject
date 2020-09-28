package app.admin.intra.controller.notice;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.admin.intra.command.IntraNoticeCommand;
import app.admin.intra.service.notice.IntraNoticeListService;
import app.admin.intra.service.notice.IntraNoticeService;

@Controller
@RequestMapping("/admin/intra/notice")
public class IntraAdminNoticeController {
	
	@Autowired
	IntraNoticeService intraNoticeService;
	@Autowired
	IntraNoticeListService intraNoticeListService;
	
	@RequestMapping("noticeList")
	public String noticeList(Model model)throws Exception {
		intraNoticeListService.listService(model);
		return "thymeleaf/admin/intra/notice/notice_list";
	}
	@RequestMapping("noticeWrite")
	public String noticeWrite()throws Exception{
		return "thymeleaf/admin/intra/notice/notice_write";
	}
	@RequestMapping(value = "noticeWritePro", method = RequestMethod.POST)
	public String noticeWritePro(IntraNoticeCommand intraNoticeCommand, HttpSession session)throws Exception{
		intraNoticeService.execute(intraNoticeCommand, session);
		return "redirect:/admin/intra/notice/noticeList";
	}
	
	
}
