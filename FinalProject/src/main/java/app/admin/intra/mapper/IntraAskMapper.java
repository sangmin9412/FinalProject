package app.admin.intra.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.admin.intra.domain.IntraAskDTO;

@Component
@Repository(value = "app.admin.intra.mapper.IntraAskMapper")
public interface IntraAskMapper {
	public void insertAsk(IntraAskDTO dto) throws Exception;
	public List<IntraAskDTO> listAsk()throws Exception;
	public int countAsk()throws Exception;
	public IntraAskDTO detailAsk(Integer askNo)throws Exception; 
	public IntraAskDTO modifyAsk(IntraAskDTO dto)throws Exception;
	public void updateAsk(IntraAskDTO dto)throws Exception;
	public void deleteAsk(IntraAskDTO dto)throws Exception;
}
