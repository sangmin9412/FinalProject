package app.admin.course.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/course")
public class CourseAdminMainController {
	@RequestMapping("/")
	public String home() {
		return "thymeleaf/admin/course/index";
	}
	
}
