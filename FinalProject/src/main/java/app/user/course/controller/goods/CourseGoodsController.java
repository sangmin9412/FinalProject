package app.user.course.controller.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.user.course.service.CartAddService;
import app.user.course.service.CourseDetailService;
import app.user.course.service.UserCourseListService;


@Controller
@RequestMapping("course/goods")
public class CourseGoodsController {
    @Autowired
    UserCourseListService userCourseListService;
    @Autowired
    CourseDetailService courseDetailService;
    @Autowired
    CartAddService cartAddService;
    
	@RequestMapping("goodsList")
	public String goodsList(@RequestParam(value = "page" , defaultValue = "1")Integer page, Model model) throws Exception{
		userCourseListService.userCourseList(page,model);
		return "thymeleaf/course/goods/course_list";
	}	

	@RequestMapping(value = "goodsView", method = RequestMethod.GET)
	public String goodsView(@RequestParam(value="id") String venId, Model model)  throws Exception{
		courseDetailService.courseDetail(venId, model);
		return "thymeleaf/course/goods/course_view";
	}
	
	@RequestMapping(value = "cart", method = RequestMethod.GET)
	public String goodsCart(@RequestParam(value="goodsNo") String goodsNo, HttpSession session, Model model)  throws Exception{
		cartAddService.cartAdd(goodsNo, session, model);
		return "thymeleaf/course/goods/course_cart";
	}
	@RequestMapping("order")
	public String goodsOrder() {
		return "thymeleaf/course/goods/course_order";
	}
}
