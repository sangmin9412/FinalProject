package app.admin.intra.service.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.intra.command.IntraNoticeCommand;
import app.admin.intra.domain.IntraNoticeDTO;
import app.admin.intra.mapper.IntraNoticeMapper;
import app.command.AuthInfo;

@Service
@Component
public class IntraNoticeListService {
	
	@Autowired
	IntraNoticeMapper intraNoticeMapper;

	public void listService(Model model)throws Exception{
				
		List<IntraNoticeDTO> lists = intraNoticeMapper.viewNotice();
		
		
	   model.addAttribute("noticeList", lists);
	 
		
	}
}
