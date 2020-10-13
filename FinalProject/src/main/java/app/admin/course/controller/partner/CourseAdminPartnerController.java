package app.admin.course.controller.partner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.admin.course.command.PartnerCommand;
import app.admin.course.service.PartnerDeleteService;
import app.admin.course.service.PartnerDetailService;
import app.admin.course.service.PartnerJoinService;
import app.admin.course.service.PartnerListService;
import app.admin.course.service.PartnerModifyService;

@Controller
@RequestMapping("/admin/course/partner")
public class CourseAdminPartnerController {
	@Autowired
	PartnerListService partnerListService;
	@Autowired
	PartnerJoinService partnerJoinService;
	@Autowired
	PartnerDetailService partnerDetailService;
	@Autowired
	PartnerDeleteService partnerDeleteService;
	@Autowired
	PartnerModifyService partnerModifyService;
	
	@RequestMapping("partnerList")
	public String partnerList(
				@RequestParam(value = "page" , defaultValue = "1") Integer page, 
				Model model
			) throws Exception{
		partnerListService.partnerList(model,page);
		return "thymeleaf/admin/course/partner/partner_list";
	}

	@RequestMapping("partnerWrite")
	public String partnerWrite(PartnerCommand partnerCommand) {
		return "thymeleaf/admin/course/partner/partner_write";
	}
	
	@RequestMapping(value = "partnerJoinOk", method = RequestMethod.POST)
	public String partnerJoinOk(
				@Validated PartnerCommand partnerCommand, 
				BindingResult result, Model model
			) throws Exception{
		if (result.hasErrors()) {
			return "thymeleaf/admin/course/partner/partner_write";
		}
		Integer i = partnerJoinService.insertPartner(partnerCommand,model);
		if( i == null) return "thymeleaf/admin/course/partner/partner_write";
		return "redirect:/admin/course/partner/partnerList";
	}
	
	@RequestMapping(value = "partnerView", method = RequestMethod.GET)
	public String partnerView(
				@RequestParam(value="id") String venId, 
				Model model
			)  throws Exception{
		partnerDetailService.partnerDetail(venId, model);
		return "thymeleaf/admin/course/partner/partner_view";
	}
	@RequestMapping(value = "partnerDelete", method = RequestMethod.GET)
	public String partnerDelete(@RequestParam(value="id") String venId) throws Exception{
		partnerDeleteService.partnerDelete(venId);
		return "redirect:/admin/course/partner/partnerList";
	}
	
	@RequestMapping("partnerModify")
	public String partnerModify(
				PartnerCommand partnerCommand,
				@RequestParam(value="id") String venId, 
				Model model
			) throws Exception {
		partnerDetailService.partnerDetail(venId, model);
		return "thymeleaf/admin/course/partner/partner_modify";
	}
	
	@RequestMapping(value = "partnerModifyPro", method = RequestMethod.POST)
	public String partnerModifyPro(
				@Validated PartnerCommand partnerCommand,
				BindingResult result
			) throws Exception {
		if (result.hasErrors()) {
			return "thymeleaf/admin/course/partner/partner_modify";
		}
		partnerModifyService.partnerUpdate(partnerCommand);
		return "redirect:/admin/course/partner/partnerView?id=" + partnerCommand.getVenId();
	}
}
