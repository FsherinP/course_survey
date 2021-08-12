package com.application.survey.utils;

import java.util.Map;
import java.util.Set;

public interface Sql {
	
	public static final String INSERT_INTO = "INSERT INTO ";
	public static final String OPEN_BRACE = "(";
	public static final String VALUES_WITH_BRACE = ") VALUES (";
	public static final String QUE_MARK = "?";
	public static final String COMMA = ",";
	public static final String CLOSING_BRACE = ");";
	public final static String GET_STATEMENT = "SELECT * FROM course_survey;";
	public static final String SURVEY_TABLE = "course_survey";
	
	public static String postPreparedStatement(Map<String, Object> map) {
	    StringBuilder query = new StringBuilder();
	    query.append(INSERT_INTO + SURVEY_TABLE + OPEN_BRACE);
	    Set<String> keySet = map.keySet();
	    query.append(String.join(",", keySet) + VALUES_WITH_BRACE);
	    StringBuilder commaSepValueBuilder = new StringBuilder();
	    for(String key : keySet) {
	    	commaSepValueBuilder.append("'" + map.get(key) + "'");
	    	if(key != "id") {
	    		commaSepValueBuilder.append(COMMA);
	    	}
	    }
	    query.append(commaSepValueBuilder + CLOSING_BRACE);
	    return query.toString();
	  }
}
