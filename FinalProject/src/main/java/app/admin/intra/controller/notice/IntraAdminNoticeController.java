package app.admin.intra.controller.notice;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.admin.intra.command.IntraNoticeCommand;
import app.admin.intra.service.notice.IntraNoticeDeleteProService;
import app.admin.intra.service.notice.IntraNoticeDetailService;
import app.admin.intra.service.notice.IntraNoticeListService;
import app.admin.intra.service.notice.IntraNoticeModifyProService;
import app.admin.intra.service.notice.IntraNoticeModifyService;
import app.admin.intra.service.notice.IntraNoticeService;

@Controller
@RequestMapping("/admin/intra/notice")
public class IntraAdminNoticeController {
	
	@Autowired
	IntraNoticeService intraNoticeService;
	@Autowired
	IntraNoticeListService intraNoticeListService;
	@Autowired
	IntraNoticeDetailService intraNoticeDetailService;
	@Autowired
	IntraNoticeModifyService intraNoticeModifyService;
	@Autowired
	IntraNoticeModifyProService intraNoticeModifyProService;
	@Autowired
	IntraNoticeDeleteProService intraNoticeDeleteProService;
	
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
	@RequestMapping(value = "noticeView")
	public String noticeView(@RequestParam(value = "num")Integer notNo,Model model)throws Exception {
		intraNoticeDetailService.intraNoticeDetailService(notNo, model);
		return "thymeleaf/admin/intra/notice/notice_view";
	}
	@RequestMapping("noticeModify")
	public String noticeModify(@RequestParam(value = "num")Integer notNo,Model model)throws Exception{
		intraNoticeDetailService.intraNoticeDetailService(notNo, model);
		return "thymeleaf/admin/intra/notice/notice_modify";
	}
	@RequestMapping(value = "NoticeModifyPro", method=RequestMethod.POST)
	public String NoticeModifyPro(IntraNoticeCommand intraNoticeCommand)throws Exception{
		intraNoticeModifyProService.IntraNoticeUpdate(intraNoticeCommand);
		return "redirect:/admin/intra/notice/noticeView?num="+intraNoticeCommand.getNotNo();
		
	}
	@RequestMapping("noticedelete")
	public String noticedelete(@RequestParam(value = "num") Integer notNo)
			 throws Exception {
		return "thymeleaf/admin/intra/notice/notice_delete";
	}
	@RequestMapping("noticeDeletePro")
	public String noticeDeletePro(@RequestParam(value = "num") Integer notNo)
		 throws Exception {
		intraNoticeDeleteProService.NoticeDel(notNo);
		return "redirect:/admin/intra/notice/noticeList";
	
	
	}
		

}