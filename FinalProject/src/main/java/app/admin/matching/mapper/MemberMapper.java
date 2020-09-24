package app.admin.matching.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.admin.matching.domain.MemberDTO;

@Component
@Repository
public interface MemberMapper {
	public Integer insertMember(MemberDTO dto) throws Exception;

}
