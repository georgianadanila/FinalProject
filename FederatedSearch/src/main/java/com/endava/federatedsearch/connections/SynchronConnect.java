package com.endava.federatedsearch.connections;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.endava.federatedsearch.models.SynchronousServerData;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SynchronConnect {

	private String syncGlobalURL="http://localhost:8081/tracktv?query=";
	@Autowired
	private RestTemplate restTemplate;
	ObjectMapper mapper = new ObjectMapper();
	String searchURL;
	String jsonString;
	byte jsonBytes[];
	String dataString;
	
	public SynchronousServerData connect(String searchTerm) throws JsonParseException, JsonMappingException, IOException {
		searchURL = syncGlobalURL+searchTerm;
		jsonString = restTemplate.getForObject(searchURL, String.class);
		jsonBytes = jsonString.getBytes();
		dataString = new String(jsonBytes, "UTF-8");
		SynchronousServerData resultData = mapper.readValue(dataString, SynchronousServerData.class);		
		return resultData;
	}
}
