package com.application.survey.Dao;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.application.survey.utils.Constants;


@Repository
public class Survey_DaoImpl implements Survey_Dao {
	
	//implement the methods
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int insertCourseFeedback(Map<String, Object> data) {
		
		String insertQuery = getPreparedStatement(data);
		int response = jdbcTemplate.update(insertQuery, data.get("topic"), data.get("rating"), data.get("comments"), data.get("id"));  //instead of jdbcTemplate.update, use jdbcTemplate.queryForList(getQuery)
		return response;
	}	
	
	// Method to create SQL insert statement
	public static String getPreparedStatement(Map<String, Object> map) {
		    StringBuilder query = new StringBuilder();
		    query.append( Constants.INSERT_INTO + Constants.SURVEY_TABLE + Constants.OPEN_BRACE);
		    Set<String> keySet = map.keySet();
		    query.append(String.join(",", keySet) + Constants.VALUES_WITH_BRACE);
		    StringBuilder commaSepValueBuilder = new StringBuilder();
		    for (int i = 0; i < keySet.size(); i++) {
		      commaSepValueBuilder.append(Constants.QUE_MARK);
		      if (i != keySet.size() - 1) {
		        commaSepValueBuilder.append(Constants.COMMA);
		      }
		    }
		    query.append(commaSepValueBuilder + Constants.CLOSING_BRACE);
		    return query.toString();
		  }
}
