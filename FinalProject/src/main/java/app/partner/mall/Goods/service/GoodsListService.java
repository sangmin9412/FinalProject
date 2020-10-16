package app.partner.mall.Goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.controller.PageAction;
import app.domain.StartEndPageDTO;
import app.partner.mall.domain.GoodsDTO;
import app.partner.mall.mapper.GoodsMapper;

@Service
@Component
public class GoodsListService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(Model model, Integer page, int i) throws Exception{
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		StartEndPageDTO startEndPageDTO = 
				new StartEndPageDTO(startRow,endRow);
		List<GoodsDTO> list=goodsMapper.selectGoods(startEndPageDTO);
		int count=goodsMapper.getGoodsCount();
		model.addAttribute("goodsList",list);
		model.addAttribute("count",count);
		PageAction pageAction = new PageAction();
		if (i == 1) {
			pageAction.page(model, count, limit, limitPage, page, "goodsList?");

		} else {
			pageAction.page(model, count, limit, limitPage, page, "List?");
		}
		
	}

}
