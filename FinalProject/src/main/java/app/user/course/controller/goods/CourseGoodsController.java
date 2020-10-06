package app.user.course.controller.goods;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("course/goods")
public class CourseGoodsController {
	@RequestMapping("goodsList")
	public String goodsList() {
		return "thymeleaf/course/goods/course_list";
	}
	@RequestMapping("goodsView")
	public String goodsView() {
		return "thymeleaf/course/goods/course_view";
	}
	@RequestMapping("cart")
	public String goodsCart() {
		return "thymeleaf/course/goods/course_cart";
	}
	@RequestMapping("order")
	public String goodsOrder() {
		return "thymeleaf/course/goods/course_order";
	}
}
