package com.application.survey.Dao;

import java.util.Map;
import java.util.List;

public interface Survey_Dao {
	
	public int insertCourseFeedback(Map<String, Object> data);
	public List<Map<String, Object>> getsCourseFeedback();

}
