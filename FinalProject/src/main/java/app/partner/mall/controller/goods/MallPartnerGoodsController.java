package app.partner.mall.controller.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.partner.mall.Goods.service.GoodsDetailService;
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
	@Autowired
	GoodsDetailService goodsDetailService;

	@RequestMapping("goodsList")
	public String goodsList(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model)
			throws Exception {
		goodsListService.execute(model, page, 1);
		return "thymeleaf/partner/mall/goods/goods_list";
	}

	@RequestMapping("goodsView")
	public String goodsView(@RequestParam(value = "goodsNo") Integer goodsNo, Model model) throws Exception {
		goodsDetailService.execute(goodsNo, model);
		return "thymeleaf/partner/mall/goods/goods_view";
	}

	@RequestMapping("goodsWrite")
	public String goodsWrite(GoodsCommand goodsCommand) {
		return "thymeleaf/partner/mall/goods/goods_write";
	}

	@RequestMapping(value = "goodsWritePro", method = RequestMethod.POST)
	public String goodsWritePro(GoodsCommand goodsCommand, HttpSession session) throws Exception {
		goodsWriteService.execute(goodsCommand, session);
		return "redirect:/partner/mall/goods/goodsList";
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
