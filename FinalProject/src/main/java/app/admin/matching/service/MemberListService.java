package app.admin.matching.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.matching.domain.MemberDTO;
import app.admin.matching.mapper.MemberMapper;
import app.controller.PageAction;
import app.domain.StartEndPageDTO;

@Service
@Component
public class MemberListService {
	@Autowired
	MemberMapper memberMapper;

	public void memberList(Model model, Integer page, int i) throws Exception {
		int limit = 10;
		int limitPage = 10;

		Long startRow = ((long) page - 1) * 10 + 1;
		Long endRow = startRow + limit - 1;
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(startRow, endRow);

		List<MemberDTO> list = memberMapper.selectMember(startEndPageDTO);
		int count = memberMapper.getMemberCount();

		model.addAttribute("memberList", list);
		model.addAttribute("count", count);
		PageAction pageAction = new PageAction();
		if (i == 1) {
			pageAction.page(model, count, limit, limitPage, page, "memberList?");

		} else {
			pageAction.page(model, count, limit, limitPage, page, "List?");
		}
	}

}
