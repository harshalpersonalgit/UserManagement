package com.myco.user.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myco.user.model.User;
import com.myco.user.repository.ElasticSearchQuery;

@RestController
public class UserRest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserUIController.class);
	
    @Autowired
    private ElasticSearchQuery elasticSearchQuery;

    @PostMapping("/saveUser")
    public ResponseEntity<Object> createOrUpdateDocument(@RequestBody User user) throws IOException, Exception {
    	LOGGER.info(">>>> createOrUpdateDocument(), User : {} " , user);
    	String response = elasticSearchQuery.createOrUpdateDocument(user);
    	LOGGER.info("<<<< createOrUpdateDocument(), response : {} " , response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	

}
