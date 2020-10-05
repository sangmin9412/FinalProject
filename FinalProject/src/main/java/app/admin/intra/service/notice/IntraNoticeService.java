package app.admin.intra.service.notice;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.admin.intra.command.IntraNoticeCommand;
import app.admin.intra.domain.IntraNoticeDTO;
import app.admin.intra.mapper.IntraNoticeMapper;
import app.command.AuthInfo;

@Service
@Component
public class IntraNoticeService {
	
	@Autowired
	IntraNoticeMapper intraNoticeMapper;
 
	public void execute(IntraNoticeCommand intraNoticeCommand, HttpSession session)throws Exception{
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		IntraNoticeDTO dto = new IntraNoticeDTO();
		
		dto.setEmpId(authInfo.getId());
		dto.setNotSub(intraNoticeCommand.getNotSub());
	    dto.setNotCont(intraNoticeCommand.getNotCont());
				
		System.out.println(intraNoticeCommand.getNotCont());
		
		intraNoticeMapper.insertNotice(dto);
	}
	
	
	
}
		

