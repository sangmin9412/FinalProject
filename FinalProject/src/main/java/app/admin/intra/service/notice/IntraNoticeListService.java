package app.admin.intra.service.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.intra.domain.IntraNoticeDTO;
import app.admin.intra.mapper.IntraNoticeMapper;

@Service
@Component
public class IntraNoticeListService {
	
	@Autowired
	IntraNoticeMapper intraNoticeMapper;

	public void listService(Model model)throws Exception{
				
		List<IntraNoticeDTO> lists = intraNoticeMapper.viewNotice();
		int count = intraNoticeMapper.noticeCount();

		
	   model.addAttribute("noticeList", lists);
	   model.addAttribute("count", count);
		
	}
}
