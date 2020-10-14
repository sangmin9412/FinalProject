package app.partner.mall.Goods.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.command.AuthInfo;
import app.partner.mall.command.GoodsCommand;
import app.partner.mall.domain.GoodsDTO;
import app.partner.mall.mapper.GoodsMapper;

@Service
@Component
public class GoodsWriteService {
	@Autowired
	GoodsMapper goodsMapper;

	public int goodsWrite(GoodsCommand goodsCommand, HttpServletRequest request) throws Exception {
		int result = 0;
		GoodsDTO goodsDTO = new GoodsDTO();
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		goodsDTO.setVenId(authInfo.getId());
		System.out.println(goodsDTO.getVenId());
		goodsDTO.setGoodsNo(goodsCommand.getGoodsNo());
		System.out.println(goodsDTO.getGoodsNo());
		goodsDTO.setGoodsName(goodsCommand.getGoodsName());
		System.out.println(goodsDTO.getGoodsName());
		goodsDTO.setGoodsPrice(goodsCommand.getGoodsPrice());
		goodsDTO.setGoodsDet(goodsCommand.getGoodsDet());
		goodsDTO.setGoodsImage(goodsCommand.getGoodsImage());
		goodsDTO.setGoodsType(goodsCommand.getGoodsType());
		result = goodsMapper.goodsInsert(goodsDTO);;
		return result;
	}

}
