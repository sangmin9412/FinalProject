package app.admin.matching.controller.event;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.admin.matching.command.EventCommand;
import app.admin.matching.service.EventDetailService;
import app.admin.matching.service.EventListService;
import app.admin.matching.service.EventWriteService;

@Controller
@RequestMapping("/admin/matching/event")
public class MatchingAdminEventController {
	@Autowired
	EventWriteService eventWriteService;
	@Autowired
	EventListService eventListService;
	@Autowired
	EventDetailService eventDetailService;
	
	@RequestMapping("eventWrite")
	public String eventWrite(EventCommand eventCommand) {
		return "thymeleaf/admin/matching/event/event_write";
	}
	@RequestMapping("eventWritePro")
	public String eventWritePro(@Validated EventCommand eventCommand, BindingResult result, Model model, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "thymeleaf/admin/matching/event/event_write";
			
		}
		String location=eventWriteService.insertEvent(eventCommand,model,request);
		
		return location;
	}
	@RequestMapping("eventList")
	public String eventList(@RequestParam(value = "page" , defaultValue = "1") Integer page, Model model) throws Exception {
		eventListService.execute(model,page);
		return "thymeleaf/admin/matching/event/event_list";
		
	}
	@RequestMapping("eventView")
	public String eventView(@RequestParam(value = "eveNo")String eveNo,Model model) throws Exception {
		eventDetailService.execute(eveNo, model);
		return "thymeleaf/admin/matching/event/event_view";
	}
	
}
