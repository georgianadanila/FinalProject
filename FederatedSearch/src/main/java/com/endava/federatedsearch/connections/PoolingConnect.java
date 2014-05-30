package com.endava.federatedsearch.connections;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.endava.federatedsearch.models.Message;
import com.endava.federatedsearch.models.PoolingServerData;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PoolingConnect {

	private String poolGlobalURL="http://localhost:8082/movies/";
	@Autowired
	private RestTemplate restTemplate;
	ObjectMapper mapper = new ObjectMapper();
	String jsonString;
	byte jsonBytes[];
	String dataString;
	ResponseEntity<?> response;
	HttpStatus status; 
	Message message;
	
	public List<PoolingServerData> connect(String searchTerm) throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		String searchURL = poolGlobalURL+searchTerm;
		/* get Json as String and convert it to UTF-8 encoding */
		jsonString = restTemplate.getForObject(searchURL, String.class);
		jsonBytes = jsonString.getBytes();
		dataString = new String(jsonBytes, "UTF-8");
	
		/* get first response as a message and the request status code */
		message = mapper.readValue(dataString, Message.class);
		response = restTemplate.getForEntity(searchURL,Message.class);
		status = response.getStatusCode();
		
		/* try refreshing the page of results, inspecting the status code everytime */
		while (!status.name().equals("OK")) {
			response = restTemplate.getForEntity(message.getDetail(), String.class); 
			Thread.sleep(1000);
			status = response.getStatusCode();
		}
		
		/* return the correct Json data */
		jsonBytes = response.getBody().toString().getBytes();
		dataString = new String(jsonBytes, "UTF-8");
		PoolingServerData[] resultArray = mapper.readValue(dataString,PoolingServerData[].class);
		List<PoolingServerData> resultData = Arrays.asList(resultArray);
		
		return resultData;
	}
}
