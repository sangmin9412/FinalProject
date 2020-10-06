package app.user.matching.controller.survey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("matching/survey")
public class MatchingSurveyController {
	@RequestMapping("surveyWrite")
	public String surveyWrite() {
		return "thymeleaf/matching/survey/survey_write";
	}
}
