package app.admin.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.course.domain.PartnerDTO;
import app.admin.course.mapper.PartnerMapper;
import app.domain.StartEndPageDTO;

@Component
@Service
public class PartnerDetailService {
	@Autowired
	PartnerMapper partnerMapper;
	
	public void partnerDetail(String venId, Model model) throws Exception{
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, venId, null);
		PartnerDTO partner = partnerMapper.selectPartner(startEndPageDTO).get(0);
		model.addAttribute("partnerCommand", partner);		
	}

}
