package app.admin.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.course.domain.MemberDTO;
import app.admin.course.domain.StartEndPageDTO;
import app.admin.course.mapper.MemberMapper;
import app.controller.PageAction;

@Component
@Service
public class MemberListService {
	@Autowired
	MemberMapper memberMapper;

	public void memberList(Model model, Integer page) throws Exception{
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(startRow,endRow);
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setStartEndPageDTO(startEndPageDTO);

		List<MemberDTO> members = memberMapper.selectMember(memberDTO);
		int count = memberMapper.memberCount();
		
		model.addAttribute("lists", members);
		model.addAttribute("count", count);
		PageAction pageAction = new PageAction();
		pageAction.page(model, count, limit, limitPage, page, "memberList?");
	}

}
