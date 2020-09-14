package app.admin.course.controller.partner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/course/partner")
public class CourseAdminPartnerController {
	@RequestMapping("partnerList")
	public String partnerList() {
		return "thymeleaf/admin/course/partner/partner_list";
	}
	@RequestMapping("partnerView")
	public String partnerView() {
		return "thymeleaf/admin/course/partner/partner_view";
	}
	@RequestMapping("partnerWrite")
	public String partnerWrite() {
		return "thymeleaf/admin/course/partner/partner_write";
	}
	@RequestMapping("partnerModify")
	public String partnerModify() {
		return "thymeleaf/admin/course/partner/partner_modify";
	}
	@RequestMapping("partnerDelete")
	public String partnerDelete() {
		return "thymeleaf/admin/course/partner/partner_delete";
	}
}
