package app.admin.mall.controller.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import app.admin.mall.service.notice.MallNoticeListService;
import app.controller.FileDownLoad;

@Controller
@RequestMapping("/admin/mall/notice")
public class MallAdminNoticeController {
	
//	@Autowired
//	MallNoticeService mallNoticeService;
	@Autowired
	MallNoticeListService mallNoticeListService;
//	@Autowired
//	MallNoticeDetailService mallNoticeDetailService;
//	@Autowired
//	MallNoticeModifyService mallNoticeModifyService;
//	@Autowired
//	MallNoticeModifyProService mallNoticeModifyProService;
//	@Autowired
//	MallNoticeDeleteProService mallNoticeDeleteProService;
	@Autowired
	FileDownLoad fileDownLoad;
	
	@RequestMapping("noticeList") // 리스트 페이지
	public String noticeList(Model model) throws Exception {
		mallNoticeListService.listService(model);
		return "thymeleaf/admin/mall/notice/notice_list";
	}

	@RequestMapping("noticeView")
	public String noticeView() {
		return "thymeleaf/admin/mall/notice/notice_view";
	}

	@RequestMapping("noticeWrite")
	public String noticeWrite() {
		return "thymeleaf/admin/mall/notice/notice_write";
	}

	@RequestMapping("noticeModify")
	public String noticeModify() {
		return "thymeleaf/admin/mall/notice/notice_modify";
	}

	@RequestMapping("noticeDelete")
	public String noticeDelete() {
		return "thymeleaf/admin/mall/notice/notice_delete";
	}
}
