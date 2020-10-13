package app.partner.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.course.domain.PartnerDTO;
import app.admin.course.mapper.PartnerMapper;
import app.command.AuthInfo;
import app.command.LoginCommand;
import app.domain.StartEndPageDTO;

@Component
@Service
public class PartnerLoginService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	PartnerMapper partnerMapper;
	
	AuthInfo authInfo;
	
	public String execute(LoginCommand loginCommand, HttpServletRequest request, Model model,
			HttpServletResponse response) throws Exception {
		String [] urlArr = request.getRequestURI().substring(1).split("/");
		String url = "/" + urlArr[0] + "/" + urlArr[1] + "/"; // /partner/mall/ 가져오기
		HttpSession session = request.getSession();
		
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, loginCommand.getUserId(), null);
		List<PartnerDTO> list = partnerMapper.selectPartner(startEndPageDTO);
		
		if (list.size() == 0) {
			System.out.println("아이디가 없습니다!");
			model.addAttribute("valid_Id", "아이디가 존재하지 않습니다.");
			return "thymeleaf/partner/common/login";
		} else {
			PartnerDTO partnerDTO = list.get(0);
			if (passwordEncoder.matches(loginCommand.getUserPw(), partnerDTO.getVenPass())) {
				System.out.println("로그인 성공!");
				authInfo = new AuthInfo(
						partnerDTO.getVenId(),
						null,
						partnerDTO.getVenName(), 
						partnerDTO.getVenPass()
					);
				session.setAttribute("authInfo", authInfo);
				
				Boolean idStore = loginCommand.getIdStore();
				Boolean autologin = loginCommand.getAutoLogin();
				
				if (autologin != null && autologin == true) {
					Cookie cookie = new Cookie("autoLogin", authInfo.getId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}
				if (idStore != null && idStore == true) {
					Cookie cookie = new Cookie("idStore", authInfo.getId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				} else {
					Cookie cookie = new Cookie("idStore", authInfo.getId());
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
				
				return "redirect:" + url;
			} else {
				System.out.println("비밀번호가 틀렸습니다!");
				model.addAttribute("valid_Pw", "비밀번호가 틀렸습니다.");
				return "thymeleaf/partner/common/login";
			}
			
		}
	}
}
