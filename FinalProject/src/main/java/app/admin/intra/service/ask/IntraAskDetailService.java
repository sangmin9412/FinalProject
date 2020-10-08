package app.admin.intra.service.ask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.intra.domain.IntraAskDTO;
import app.admin.intra.mapper.IntraAskMapper;

@Service
@Component
public class IntraAskDetailService {
	
	@Autowired
	IntraAskMapper IntraAskMapper;

	public void intraAskDetailService(Integer askNo, Model model)throws Exception{
		
		IntraAskDTO dto = IntraAskMapper.detailAsk(askNo);
		
		model.addAttribute("intraAskCommand", dto);
	}
	
}
