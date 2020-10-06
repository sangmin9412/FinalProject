package app.admin.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.course.domain.MemberDTO;
import app.admin.course.mapper.MemberMapper;

@Component
@Service
public class MemberDetailService {
	@Autowired
	MemberMapper memberMapper;

	public void memberDetail(String memId, Model model) throws Exception{
		MemberDTO member = new MemberDTO();
		member.setMemId(memId);
		member = memberMapper.selectMember(member).get(0);
		model.addAttribute("memberCommand", member);
	}
	

}
