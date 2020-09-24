package app.admin.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.command.AuthInfo;
import app.command.ChangeIdCommand;
import app.command.ChangePwCommand;
import app.domain.StartEndPageDTO;
import app.domain.UserIdChangeDTO;
import app.domain.UserPwChangeDTO;
import app.intra.domain.IntraEmployeeDTO;
import app.intra.mapper.IntraEmployeeMapper;

@Component
@Service
public class IdPwModifyService {
	@Autowired
	IntraEmployeeMapper intraEmployeeMapper;
	@Autowired
	PasswordEncoder passwordEncoder;

	public String changePw(ChangePwCommand changePwCommand, HttpServletRequest request, Model model) throws Exception {
		String [] urlArr = request.getRequestURI().substring(1).split("/");
		String url = "/" + urlArr[0] + "/" + urlArr[1] + "/"; // /admin/intra/ 가져오기
		
		if ((changePwCommand.getNewPw().length() == 0) && (!changePwCommand.isNewPwToReNewPw())) {
			model.addAttribute("valid_reNewPw", "새로운 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return "thymeleaf/admin/common/forgot-password";
		} else {
			
			StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, changePwCommand.getUserId(), null);
			IntraEmployeeDTO empDTO = null;
			List<IntraEmployeeDTO> list = intraEmployeeMapper.selectAllEmployee(startEndPageDTO);
			
			if (list.size() == 0) {
				model.addAttribute("valid_Id", "아이디가 존재하지 않습니다.");
				return "thymeleaf/admin/common/forgot-password";
			} else {
				empDTO = list.get(0);
				
				if (!empDTO.getEmpName().equals(changePwCommand.getUserName())) {
					model.addAttribute("valid_Name", "이름이 잘못 입력되었습니다.");
					return "thymeleaf/admin/common/forgot-password";
				} else if (!empDTO.getEmpEmail().equals(changePwCommand.getUserEmail())) {
					model.addAttribute("valid_Email", "이메일이 잘못 입력되었습니다.");
					return "thymeleaf/admin/common/forgot-password";
				}
				
				UserPwChangeDTO dto = new UserPwChangeDTO();
				dto.setUserId(changePwCommand.getUserId());
				dto.setUserName(changePwCommand.getUserName());
				dto.setUserEmail(changePwCommand.getUserEmail());
				dto.setNewPw(passwordEncoder.encode(changePwCommand.getNewPw()));
				intraEmployeeMapper.changePw(dto);
				model.addAttribute("url", url);
				model.addAttribute("completedText", "비밀번호가 변경되었습니다.");
				return "thymeleaf/admin/common/completed";
			}
		}
		
	}

	public String findId(ChangeIdCommand changeIdCommand, HttpServletRequest request, Model model) throws Exception {
		String [] urlArr = request.getRequestURI().substring(1).split("/");
		String url = "/" + urlArr[0] + "/" + urlArr[1] + "/"; // /admin/intra/ 가져오기
		
		UserIdChangeDTO dto = new UserIdChangeDTO();
		dto.setUserName(changeIdCommand.getUserName());
		dto.setUserEmail(changeIdCommand.getUserEmail());
		dto.setUserTel(changeIdCommand.getUserTel());
		String id = intraEmployeeMapper.findId(dto);
		
		model.addAttribute("url", url);
		model.addAttribute("completedText", "아이디 찾기");
		if (id == null) {
			model.addAttribute("notId", "입력하신 정보와 일치하는 아이디를 찾을 수 없습니다.");
		} else {
			model.addAttribute("checkId", id + " 입니다.");
		}
		
		return "thymeleaf/admin/common/completed";
	}
	
}
