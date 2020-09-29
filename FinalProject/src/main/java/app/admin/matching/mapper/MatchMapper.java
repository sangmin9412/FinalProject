package app.admin.matching.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.admin.matching.domain.MatchDTO;

@Component
@Repository
public interface MatchMapper {
	public Integer matchInsert(MatchDTO dto) throws Exception;

}
