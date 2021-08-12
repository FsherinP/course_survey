package com.application.survey.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.model.SurveyModel;
import com.application.survey.service.SurveyService;
import com.application.survey.utils.Constants;

@RestController
@RequestMapping(Constants.SURVEY)
public class SurveyController {
	
	@Autowired
	private SurveyService survey;
			
	@PostMapping (Constants.SURVEY_DATA)
	public Map<String, Object> insertSurvey( @RequestBody SurveyModel feedback) {
		return survey.insertFeedback(feedback);
	}
	
	@GetMapping (Constants.GET_DATA)
	public Map<String, List<Map<String, Object>>> getData() {
		return survey.getFeedback();
	}
}
