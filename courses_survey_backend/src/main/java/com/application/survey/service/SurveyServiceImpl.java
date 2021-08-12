package com.application.survey.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.SurveyModel;
import com.application.survey.dao.SurveyDao;
import com.application.survey.utils.Constants;
import com.google.gson.Gson;


@Service
public class SurveyServiceImpl implements SurveyService{
	
	@Autowired
	SurveyDao surveyDao;
	
	@Autowired
	RestHighLevelClient highLevelClient;
	
	@Autowired
	RestHighLevelClient client;
		
	@Override
	public Map<String, Object> insertFeedback(SurveyModel data) {
		Map<String, Object> map = data.getUser();
		Map<String, Object> responseData = new HashMap<> ();
		String id = getUniqueId();
		
		IndexRequest request = new IndexRequest("courses_survey","feedback", id)
				  .source(new Gson().toJson(data.getUser()), XContentType.JSON);
		request.id(UUID.randomUUID().toString());
		
		try {
			IndexResponse response = highLevelClient.index(request);
			responseData = getResponse(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		map.put(Constants.ID , id);
		surveyDao.insertCourseFeedback(map);
//		if(status == 1) {
//			responseData = getResponse(status);
//		}
		return responseData;
	}
	
	@Override
	public Map<String, List<Map<String, Object>>> getFeedback() {
		
		SearchRequest searchRequest = new SearchRequest("courses_survey");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchAllQuery());
		searchRequest.source(searchSourceBuilder);

		SearchResponse searchResponse = null;
		try {
			searchResponse = (SearchResponse) client.search(searchRequest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<Map<String, Object>> esResponse = new ArrayList<>();
		
		for(int i = 0; i < searchResponse.getHits().totalHits; i++) {
			esResponse.add(searchResponse.getHits().getAt(i).getSourceAsMap());
		}
		
		Map<String, List<Map<String, Object>>> responseData = new HashMap<>();
		responseData.put(Constants.RESPONSE,esResponse );
		return responseData;
	}
	
	public Map<String, Object> getResponse(int status) {
		Map<String, Object> response = new HashMap<>();
		response.put("response message", Constants.SUCCESS);
		response.put("status", status);
        return response;
    }
	
	public String getUniqueId() {
		return UUID.randomUUID().toString();
	}
	
}
