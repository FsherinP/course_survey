package com.application.survey.Service;

import java.util.Map;
import java.util.List;

public interface Survey_Service {
	
	public Map<String, Object> insertFeedback(Object data);
	public Map<String, List<Map<String, Object>>> getFeedback();
	
}
