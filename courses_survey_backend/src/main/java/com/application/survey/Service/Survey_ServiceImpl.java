package com.application.survey.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.survey.Dao.Survey_Dao;


@Service
public class Survey_ServiceImpl implements Survey_Service{
	
	@Autowired
	Survey_Dao surveyDao;

	@Override
	public Map<String, Object> insertFeedback(Map<String, Object> data) {
		Map<String, Object> responseData = new HashMap<> ();
		data.put("id", generateUniqueId());
		int status = surveyDao.insertCourseFeedback(data);
		if(status == 1) {
			responseData.put("response message", "Success");
			responseData.put("status", status);
		}
		return responseData;
	}
	
	public String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
	
	
}
