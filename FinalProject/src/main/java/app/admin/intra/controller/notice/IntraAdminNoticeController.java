package app.admin.intra.controller.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/intra/notice")
public class IntraAdminNoticeController {
	@RequestMapping("noticeList")
	public String noticeList() {
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
	@RequestMapping("noticeModify")
	public String noticeModify() {
		return "thymeleaf/admin/intra/notice/notice_modify";
	}
	@RequestMapping("noticeDelete")
	public String noticeDelete() {
		return "thymeleaf/admin/intra/notice/notice_delete";
	}
}
