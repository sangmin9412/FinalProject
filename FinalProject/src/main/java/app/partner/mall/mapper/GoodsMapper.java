package app.partner.mall.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.domain.StartEndPageDTO;
import app.partner.mall.domain.GoodsDTO;

@Component
@Repository
public interface GoodsMapper {
	public Integer goodsInsert(GoodsDTO dto) throws Exception;
	public List<GoodsDTO> selectGoods(StartEndPageDTO startEndPageDTO) throws Exception;
	public Integer getGoodsCount();
	public void goodsUpdate(GoodsDTO dto) throws Exception;

}
