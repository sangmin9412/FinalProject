package app.admin.course.controller.payment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/course/payment")
public class CourseAdminPaymentController {
	@RequestMapping("paymentList")
	public String paymentList() {
		return "thymeleaf/admin/course/payment/payment_list";
	}
	@RequestMapping("paymentView")
	public String paymentView() {
		return "thymeleaf/admin/course/payment/payment_view";
	}
}
