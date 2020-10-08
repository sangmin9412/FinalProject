package app.admin.intra.service.ask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.intra.domain.IntraAskDTO;
import app.admin.intra.mapper.IntraAskMapper;

@Service
@Component
public class IntraAskListService {
	
	@Autowired
	IntraAskMapper intraAskMapper;

	public void listServie(Model model)throws Exception{
		
		List<IntraAskDTO> lists = intraAskMapper.listAsk();
		int count = intraAskMapper.countAsk();
		
		
		model.addAttribute("askList", lists);
		model.addAttribute("count",count);
	}
	
}
