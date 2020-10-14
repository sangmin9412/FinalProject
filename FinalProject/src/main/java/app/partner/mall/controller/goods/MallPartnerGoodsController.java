package app.partner.mall.controller.goods;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.partner.mall.Goods.service.GoodsListService;
import app.partner.mall.Goods.service.GoodsWriteService;
import app.partner.mall.command.GoodsCommand;

@Controller
@RequestMapping("/partner/mall/goods")
public class MallPartnerGoodsController {
	@Autowired
	GoodsWriteService goodsWriteService;
	@Autowired
	GoodsListService goodsListService;
	
	@RequestMapping("goodsList")
	public String goodsList(@RequestParam(value = "page",defaultValue = "1")Integer page, Model model)throws Exception {
		goodsListService.execute(model, page);
		return "thymeleaf/partner/mall/goods/goods_list";
	}
	@RequestMapping("goodsView")
	public String goodsView() {
		return "thymeleaf/partner/mall/goods/goods_view";
	}
	@RequestMapping("goodsWrite")
	public String goodsWrite(GoodsCommand goodsCommand) {
		return "thymeleaf/partner/mall/goods/goods_write";
	}
	@RequestMapping(value = "goodsWritePro", method = RequestMethod.POST)
	public String goodsWritePro(@Validated GoodsCommand goodsCommand, BindingResult result, HttpServletRequest request)
			throws Exception {

		if (result.hasErrors()) {
			System.out.println("에러");
			return "thymeleaf/partner/mall/goods/goods_write";
		}
		int i = goodsWriteService.goodsWrite(goodsCommand, request);
		if (i >= 1) {
			return "redirect:/partner/mall/goods/goodsList";
		}
		
		return "thymeleaf/partner/mall/goods/goods_write";
	}
	@RequestMapping("goodsModify")
	public String goodsModify() {
		return "thymeleaf/partner/mall/goods/goods_modify";
	}
	@RequestMapping("goodsDelete")
	public String goodsDelete() {
		return "thymeleaf/partner/mall/goods/goods_delete";
	}
}
