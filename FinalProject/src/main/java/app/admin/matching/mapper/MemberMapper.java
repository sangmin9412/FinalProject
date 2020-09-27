package app.admin.matching.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.admin.matching.domain.MemberAddDTO;
import app.admin.matching.domain.MemberDTO;

@Component
@Repository
public interface MemberMapper {
	public Integer insertMember(MemberDTO dto) throws Exception;
	public Integer insertMemberAdd(MemberAddDTO dto) throws Exception;
	public List<MemberDTO> selectMember(MemberDTO memberDTO) throws Exception;
}