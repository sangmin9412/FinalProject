package app.admin.mall.service.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.mall.domain.MallNoticeDTO;
import app.admin.mall.mapper.MallNoticeMapper;

@Service
@Component
public class MallNoticeListService {
	
	@Autowired
	MallNoticeMapper mallNoticeMapper;

	public void listService(Model model)throws Exception{
				
		List<MallNoticeDTO> lists = mallNoticeMapper.viewNotice();
		int count = mallNoticeMapper.noticeCount();

		
	   model.addAttribute("noticeList", lists);
	   model.addAttribute("count", count);
		
	}
}
