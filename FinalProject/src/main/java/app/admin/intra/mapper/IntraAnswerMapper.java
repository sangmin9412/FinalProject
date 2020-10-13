package app.admin.intra.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.admin.intra.domain.IntraAnswerDTO;

@Component
@Repository(value = "app.admin.intra.mapper.IntraAnswerMapper")
public interface IntraAnswerMapper {
	
	public void insertAnswer(IntraAnswerDTO dto)throws Exception;

}
