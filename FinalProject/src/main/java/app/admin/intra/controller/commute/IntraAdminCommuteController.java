package app.admin.intra.controller.commute;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/intra/commute")
public class IntraAdminCommuteController {
	@RequestMapping("commuteList")
	public String commuteList() {
		return "thymeleaf/admin/intra/commute/commute_list";
	}
}
