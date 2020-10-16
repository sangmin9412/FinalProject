package app.partner.mall.Goods.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import app.command.AuthInfo;
import app.partner.mall.command.GoodsCommand;
import app.partner.mall.domain.GoodsDTO;
import app.partner.mall.mapper.GoodsMapper;

@Service
@Component
public class GoodsWriteService {
	@Autowired
	GoodsMapper goodsMapper;

	public void execute(GoodsCommand goodsCommand, HttpSession session) throws Exception {
		GoodsDTO goodsDTO = new GoodsDTO();
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
		
		
		try {
			String PATH = "/goods/upload";
			String filePath = session.getServletContext().getRealPath(PATH);
			MultipartFile mf = goodsCommand.getReport();
			String original = mf.getOriginalFilename();
			String originalFileExtension = original.substring(original.lastIndexOf("."));
			String store = UUID.randomUUID().toString().replace("-", "") + originalFileExtension;
			goodsDTO.setGoodsStore(store);
			goodsDTO.setGoodsOriginal(original);

			File file = new File(filePath + "/" + store);
			goodsDTO.setGoodsSize(mf.getSize());
			System.out.println(mf.getSize());
			mf.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			goodsMapper.goodsInsert(goodsDTO);
		}
	}

}
