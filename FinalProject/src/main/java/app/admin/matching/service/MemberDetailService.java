package app.admin.matching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.matching.domain.MemberDTO;
import app.admin.matching.mapper.MemberMapper;
import app.domain.StartEndPageDTO;

@Component
@Service
public class MemberDetailService {
	@Autowired
	MemberMapper memberMapper;

	public void memberDetail(Model model, String memId) throws Exception {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, memId, null);
		MemberDTO list = memberMapper.selectMember(dto).get(0);
		
		model.addAttribute("memberCommand", list);
		
	}
	
	
	
}
