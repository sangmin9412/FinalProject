package app.partner.mall.Goods.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.domain.StartEndPageDTO;
import app.partner.mall.domain.GoodsDTO;
import app.partner.mall.mapper.GoodsMapper;

@Service
@Component
public class GoodsDetailService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(Integer goodsNo, Model model) throws Exception{
		GoodsDTO dto = goodsMapper.goodsDetail(goodsNo);
		model.addAttribute("goodsDTO",dto);
		
	}

}
