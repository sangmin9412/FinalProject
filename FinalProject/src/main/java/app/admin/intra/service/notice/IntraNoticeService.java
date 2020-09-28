package app.admin.intra.service.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.admin.intra.command.IntraNoticeCommand;
import app.admin.intra.domain.IntraNoticeDTO;
import app.admin.intra.mapper.IntraNoticeMapper;

@Service
@Component
public class IntraNoticeService {
	
	@Autowired
	IntraNoticeMapper intraNoticeMapper;
 
	public void execute(IntraNoticeCommand IntraNoticeCommand)throws Exception{
		
		IntraNoticeDTO dto = new IntraNoticeDTO();
		
		dto.setNotCont(IntraNoticeCommand.getNotCont());
		dto.setNotSub(IntraNoticeCommand.getNotSub());
		
		
		intraNoticeMapper.insertNotice(dto);
	}
	
	
	
}
		

