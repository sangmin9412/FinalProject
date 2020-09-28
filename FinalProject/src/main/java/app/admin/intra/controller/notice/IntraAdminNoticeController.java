package app.admin.intra.controller.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.admin.intra.command.IntraNoticeCommand;
import app.admin.intra.service.employee.IntraEmployeeListService;
import app.admin.intra.service.notice.IntraNoticeListService;

@Controller
@RequestMapping("/admin/intra/notice")
public class IntraAdminNoticeController {
	
	@Autowired
	IntraEmployeeListService intraEmployeeListService;
	@Autowired
	IntraNoticeListService intraNoticeService;
	
	@RequestMapping("noticeList")
	public String noticeList(@RequestParam(value = "page", defaultValue = "1") Integer page,
			Model model)throws Exception {
		intraNoticeService.noticeNoticeService(intraNoticeCommand, model);
		return "thymeleaf/admin/intra/notice/notice_list";
	}
	@RequestMapping("noticeView")
	public String noticeView() {
		return "thymeleaf/admin/intra/notice/notice_view";
	}
	@RequestMapping("noticeWrite")
	public String noticeWrite() {
		return "thymeleaf/admin/intra/notice/notice_write";
	}
	@RequestMapping(value = "noticeWritePro", method = RequestMethod.POST)
	public String noticeWrited(IntraNoticeCommand intraNoticeCommand,Model model)throws Exception {
		intraNoticeService.noticeNoticeService(intraNoticeCommand, model);
	 return  "redirect:/admin/intra/notice/noticeList/";
 }
	@RequestMapping("noticeModify")
	public String noticeModify() {
		return "thymeleaf/admin/intra/notice/notice_modify";
	}
	@RequestMapping("noticeDelete")
	public String noticeDelete() {
		return "thymeleaf/admin/intra/notice/notice_delete";
	}
}
