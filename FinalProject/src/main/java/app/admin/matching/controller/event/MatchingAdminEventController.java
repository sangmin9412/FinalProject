package app.admin.matching.controller.event;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import app.admin.matching.command.EventCommand;
import app.admin.matching.service.EventWriteService;

@Controller
@RequestMapping("/admin/matching/event")
public class MatchingAdminEventController {
	@Autowired
	EventWriteService eventWriteService;
	
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
	
}
