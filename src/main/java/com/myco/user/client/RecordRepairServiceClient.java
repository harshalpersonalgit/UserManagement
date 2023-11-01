package com.myco.user.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myco.user.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecordRepairServiceClient {

	private static final String URI = "http://localhost:8081/";

	public ResponseEntity<String> storeUserToRepairService(User user, String url) {
		RestTemplate restTemplate = new RestTemplate();

		try {
			StringBuilder resourceUrl = new StringBuilder();
			resourceUrl.append(URI).append(url);

			// Create the request body by wrapping
			// the object in HttpEntity
			HttpEntity<User> request = new HttpEntity<>(user);

			return restTemplate.exchange(resourceUrl.toString(), HttpMethod.POST, request, String.class);
		} catch (Exception e) {
			log.error(">>>> error while calling 'record-repaire-service' , exception : {} ", e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
	}

}
