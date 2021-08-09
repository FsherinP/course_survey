package com.application.survey.Controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.application.survey.Service.Survey_Service;
import com.application.survey.utils.Constants;

@RestController
@RequestMapping(Constants.SURVEY)
public class Survey_Controller {
	
	@Autowired
	private Survey_Service survey;	
	
	@PostMapping (Constants.SURVEY_DATA)
	public Map<String, Object> insertSurvey( @RequestBody Map<String, Object> data) {
		return survey.insertFeedback(data);
	}
	
	@GetMapping (Constants.GET_DATA)
	public Map<String, List<Map<String, Object>>> getData() {
		return survey.getFeedback();
	}
	
}
