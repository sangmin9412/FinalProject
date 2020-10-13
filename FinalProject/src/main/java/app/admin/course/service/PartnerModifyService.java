package app.admin.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.admin.course.command.PartnerCommand;
import app.admin.course.domain.PartnerDTO;
import app.admin.course.mapper.PartnerMapper;

@Component
@Service
public class PartnerModifyService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	PartnerMapper partnerMapper;

	public void partnerUpdate(PartnerCommand partnerCommand) throws Exception {
		PartnerDTO dto = new PartnerDTO();
		dto.setVenId(partnerCommand.getVenId());
		dto.setVenPass(passwordEncoder.encode(partnerCommand.getVenPass()));
		dto.setVenName(partnerCommand.getVenName());
		dto.setVenTel(partnerCommand.getVenTel());
		dto.setVenNo(partnerCommand.getVenNo());
		dto.setVenAddr(partnerCommand.getVenAddr());
		dto.setVenCeo(partnerCommand.getVenCeo());
		dto.setVenCdate(partnerCommand.getVenCdate());
		dto.setVenAcnt(partnerCommand.getVenAcnt());
		dto.setVenAcntNo(partnerCommand.getVenAcntNo());
		dto.setVenType(partnerCommand.getVenType());
		partnerMapper.partnerUpdate(dto);
	}
	
}
