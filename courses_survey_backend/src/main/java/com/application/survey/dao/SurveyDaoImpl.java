package com.application.survey.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.application.survey.utils.Sql;

@Repository
public class SurveyDaoImpl implements SurveyDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertCourseFeedback(Map<String, Object> data) {
		String insertQuery = Sql.postPreparedStatement(data);
		int response = jdbcTemplate.update(insertQuery);
		return response;
	}
}
