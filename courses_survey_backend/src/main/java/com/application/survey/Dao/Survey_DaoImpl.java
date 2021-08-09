package com.application.survey.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.application.survey.utils.Constants;

@Repository
public class Survey_DaoImpl implements Survey_Dao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int insertCourseFeedback(Map<String, Object> data) {
		
		String insertQuery = postPreparedStatement(data);
		int response = jdbcTemplate.update(insertQuery);
		return response;
	}	
	
	@Override
	public List<Map<String, Object>> getsCourseFeedback() {
		List<Map<String, Object>> courseSurveyData = new ArrayList<>();
		courseSurveyData = jdbcTemplate.queryForList(Constants.GET_STATEMENT);
		System.out.println(courseSurveyData);
		return courseSurveyData;
	}
	
	public static String postPreparedStatement(Map<String, Object> map) {
		    StringBuilder query = new StringBuilder();
		    query.append( Constants.INSERT_INTO + Constants.SURVEY_TABLE + Constants.OPEN_BRACE);
		    Set<String> keySet = map.keySet();
		    query.append(String.join(",", keySet) + Constants.VALUES_WITH_BRACE);
		    StringBuilder commaSepValueBuilder = new StringBuilder();
		    for(String key : keySet) {
		    	commaSepValueBuilder.append("'" + map.get(key) + "'");
		    	if(key != "id") {
		    		commaSepValueBuilder.append(Constants.COMMA);
		    	}
		    }
		    query.append(commaSepValueBuilder + Constants.CLOSING_BRACE);
		    return query.toString();
		  }
}
