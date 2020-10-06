package app.admin.course.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.admin.course.domain.MemberDTO;

@Component
@Repository(value = "app.admin.course.mapper")
public interface MemberMapper {
	public Integer insertMember(MemberDTO memberDTO) throws Exception;
	public List<MemberDTO> selectMember(MemberDTO memberDTO) throws Exception;
	public Integer memberCount();	
	public Integer memberDelete(String memId)throws Exception;
}
