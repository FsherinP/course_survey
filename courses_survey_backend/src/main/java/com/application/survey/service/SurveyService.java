package com.application.survey.service;

import java.util.List;
import java.util.Map;

import com.application.model.SurveyModel;

public interface SurveyService {
	
	public Map<String, Object> insertFeedback(SurveyModel data);
	Map<String, List<Map<String, Object>>> getFeedback();

}
