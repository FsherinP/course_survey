package com.application.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "course_survey")
public class SurveyModel {
	@Id
	private String id;
	
	@Field(type = FieldType.Object, name = "survey_data")
	  private Map<String, Object> user;

	public Map<String, Object> getUser() {
		return user;
	}

	public void setUser(Map<String, Object> user) {
		this.user = user;
	}
	
}
