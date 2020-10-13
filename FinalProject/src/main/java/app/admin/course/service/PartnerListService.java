package app.admin.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.course.domain.PartnerDTO;
import app.admin.course.mapper.PartnerMapper;
import app.controller.PageAction;
import app.domain.StartEndPageDTO;

@Component
@Service
public class PartnerListService {
    @Autowired
    PartnerMapper partnerMapper;
	
	public void partnerList(Model model, Integer page) throws Exception{
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long)page -1 ) * limit +1;
		Long endRow = startRow + limit - 1;
		
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(startRow, endRow);

		List<PartnerDTO> partners = partnerMapper.selectPartner(startEndPageDTO);
		int count = partnerMapper.partnerCount();
		
		model.addAttribute("p_lists", partners);
		model.addAttribute("p_count", count);
		model.addAttribute("limit", limit);
		model.addAttribute("page", page);
		PageAction pageAction = new PageAction();
		pageAction.page(model, count, limit, limitPage, page, "partnerList");
	}

}
