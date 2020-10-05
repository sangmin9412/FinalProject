package app.admin.matching.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.matching.domain.MemberDTO;
import app.admin.matching.domain.SurveyDTO;
import app.admin.matching.mapper.SurveyMapper;

@Service
@Component
public class SurveySearchService {
	@Autowired
	SurveyMapper surveyMapper;
	public void execute(String memId, Model model) throws Exception {
		SurveyDTO surveyDTO=new SurveyDTO();
		surveyDTO=surveyMapper.selectSurvey(memId);
		List<MemberDTO> list=surveyMapper.selectMember(surveyDTO);
		model.addAttribute("memberList",list);
		
	}

}
