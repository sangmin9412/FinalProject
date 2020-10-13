package app.admin.course.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import app.admin.course.command.PartnerCommand;
import app.admin.course.domain.PartnerDTO;
import app.admin.course.mapper.PartnerMapper;

@Component
@Service
@Transactional
public class PartnerJoinService {

	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	PartnerMapper partnerMapper;
//	@Autowired
//	MailAction mailAction;
	public Integer insertPartner(PartnerCommand partnerCommand, Model model) {
		if(!partnerCommand.isVenPassEqualToReVenPass()) {
			model.addAttribute("valid_ReVenPass", "비밀번호가 일치하지 않습니다.");
			return null;
		}
		Integer result = null;
		PartnerDTO partnerDTO = new PartnerDTO();
		partnerDTO.setVenId(partnerCommand.getVenId());
		partnerDTO.setVenPass(passwordEncoder.encode(partnerCommand.getReVenPass()));
		partnerDTO.setVenName(partnerCommand.getVenName());
		partnerDTO.setVenTel(partnerCommand.getVenTel());
		partnerDTO.setVenNo(partnerCommand.getVenNo());
		partnerDTO.setVenAddr(partnerCommand.getVenAddr());
		partnerDTO.setVenCeo(partnerCommand.getVenCeo());
		partnerDTO.setVenCdate(partnerCommand.getVenCdate());
		partnerDTO.setVenAcnt(partnerCommand.getVenAcnt());
		partnerDTO.setVenAcntNo(partnerCommand.getVenAcntNo());
		partnerDTO.setVenType(partnerCommand.getVenType());
		try {
			result = partnerMapper.insertPartner(partnerDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	
	}


}
