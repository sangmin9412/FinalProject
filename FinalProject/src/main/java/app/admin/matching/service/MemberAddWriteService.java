package app.admin.matching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.admin.matching.command.MemberAddCommand;
import app.admin.matching.domain.MemberAddDTO;
import app.admin.matching.mapper.MemberMapper;

@Service
@Component
@Transactional
public class MemberAddWriteService {
	@Autowired
	MemberMapper memberMapper;
	public Integer insertMemberAdd(MemberAddCommand memberAddCommand) throws Exception {
		Integer result=null;
		MemberAddDTO memberAddDTO=new MemberAddDTO();
		memberAddDTO.setMemBlood(memberAddCommand.getMemBlood());
		memberAddDTO.setMemCareer(memberAddCommand.getMemCareer());
		memberAddDTO.setMemHgt(memberAddCommand.getMemHgt());
		memberAddDTO.setMemHobby(memberAddCommand.getMemHobby());
		memberAddDTO.setMemJob(memberAddCommand.getMemJob());
		memberAddDTO.setMemRlg(memberAddCommand.getMemRlg());
		memberAddDTO.setMemSalary(memberAddCommand.getMemSalary());
		memberAddDTO.setMemWgt(memberAddCommand.getMemWgt());
		
		result=memberMapper.insertMemberAdd(memberAddDTO);
		
		
		return result;
	}

}
