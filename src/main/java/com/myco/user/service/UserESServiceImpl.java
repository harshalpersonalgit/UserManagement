package com.myco.user.service;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myco.user.client.RecordRepairServiceClient;
import com.myco.user.model.User;
import com.myco.user.repository.ElasticSearchQuery;

@Service
public class UserESServiceImpl implements UserESService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserESServiceImpl.class);
	
	@Autowired
	private ElasticSearchQuery elasticSearchQuery;
	
	@Autowired
	private RecordRepairServiceClient repairServiceClient;
	
	@Override
	public List<User> getAllDocuments() {
		LOGGER.info(">>>> getAllDocuments()");
		try { 
			List<User> users = elasticSearchQuery.searchAllDocuments();
			
			if(null != users && !users.isEmpty()) {
				LOGGER.info("<<<< getAllDocuments(), Users : {}", users);
				return users;
			}
		} catch (Exception e) {
			LOGGER.error(">>>> error on  getAllDocuments() <<<< failed to fetch User record from elastic search, Exception : {} " , e.getMessage());
			LOGGER.info(">>>> Calling record repair service");
			// IN CASE OF FAILURE WE WILL BE FETCHING DATA FROM RECORD REPAIR SERVICE
			
		}
		return Collections.emptyList();
	}

	@Override
	public String saveUser(User user) {
		LOGGER.info(">>>> saveUser() , User : {}" , user);
		try {
			return elasticSearchQuery.createOrUpdateDocument(user);
		} catch (Exception e) {
			LOGGER.error(">>>> error on saveUser() <<<< Exception : {} " , e.getMessage());
			LOGGER.info(">>>> calling record-repair-service >>>>");
			ResponseEntity<String> response = repairServiceClient.storeUserToRepairService(user, "/repair");
			if(null!=response && response.hasBody()) {
				LOGGER.info("<<<< 'record-repair-service' <<<< Response : {} ", response.getBody());
				return response.getBody();
			}			
		}
		return null;
	}

	@Override
	public String deleteUser(String id) {
		LOGGER.info(">>>> deleteUser() , id : {} " , id);
		
		try {
			return  elasticSearchQuery.deleteDocumentById(id);
		} catch (Exception e) {
			LOGGER.error(">>>> error on deleteUser() <<<< Exception : {} " , e.getMessage());
			return "Error while performing Delete operation! please try after sometime"; 
		}
	}

	@Override
	public User updateUser(String id) {
		LOGGER.info(">>>> updateUser() , id : {} " , id);
		try {
			User user =  elasticSearchQuery.getDocumentById(id);
			if(null != user) {
				LOGGER.info(">>>> updateUser , id : {}  ", id);
				return user;
			}
		} catch (Exception e) {
			LOGGER.error(">>>> error on updateUser() <<<< Exception : {} " , e.getMessage());
			
		}
		return null;
	}
	
}
