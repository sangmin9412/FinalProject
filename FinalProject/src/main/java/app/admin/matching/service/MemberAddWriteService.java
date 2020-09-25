package app.admin.matching.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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

	public Integer insertMemberAdd(MemberAddCommand memberAddCommand, HttpSession session) throws Exception {
		Integer result = null;
		MemberAddDTO memberAddDTO = new MemberAddDTO();
		memberAddDTO.setMemId("aaa"); // 하드코딩
		/* String memId=((AuthInfo)session.getAttribute("authInfo")).getId(); */
		memberAddDTO.setMemBlood(memberAddCommand.getMemBlood());
		System.out.println(memberAddDTO.getMemBlood());
		memberAddDTO.setMemCareer(memberAddCommand.getMemCareer());
		System.out.println(memberAddDTO.getMemCareer());
		memberAddDTO.setMemHgt(memberAddCommand.getMemHgt());
		System.out.println(memberAddDTO.getMemHgt());
		/* memberAddDTO.setMemHobby(memberAddCommand.getMemHobby()); */

		List list = new ArrayList();
		list = memberAddCommand.getMemHobby();
		String[] memHobby = (String[]) list.toArray(new String[list.size()]);
		String sum = "";
		for (String s : memHobby) {
			sum += s + "`";
		}

		System.out.println(sum);
		memberAddDTO.setMemHobby(sum);
		memberAddDTO.setMemJob(memberAddCommand.getMemJob());
		System.out.println(memberAddDTO.getMemJob());
		memberAddDTO.setMemRlg(memberAddCommand.getMemRlg());
		System.out.println(memberAddDTO.getMemRlg());
		memberAddDTO.setMemSalary(memberAddCommand.getMemSalary());
		System.out.println(memberAddDTO.getMemSalary());
		memberAddDTO.setMemWgt(memberAddCommand.getMemWgt());
		System.out.println(memberAddDTO.getMemWgt());
		result = memberMapper.insertMemberAdd(memberAddDTO);

		return result;
	}

}
