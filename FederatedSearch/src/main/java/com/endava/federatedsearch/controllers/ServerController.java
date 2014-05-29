package com.endava.federatedsearch.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.endava.federatedsearch.MergeResults;
import com.endava.federatedsearch.connections.PoolingConnect;
import com.endava.federatedsearch.connections.SynchronConnect;
import com.endava.federatedsearch.models.MergeResultData;
import com.endava.federatedsearch.models.PoolingServerData;
import com.endava.federatedsearch.models.SynchronousServerData;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ServerController {
	
	@Autowired
	private SynchronConnect synchronConnect;
	@Autowired
	private PoolingConnect poolingConnect;
	@Autowired
	private MergeResults mergeResults;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String serachPage(Locale locale, Model model) {
		return "search";
	}

	
	@RequestMapping(value = "/results", method = RequestMethod.POST)
	public String synchronResultPage(@Validated SynchronousServerData server, Model model, @RequestParam String searchTerm) throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		SynchronousServerData synchData = synchronConnect.connect(searchTerm);	
		List<PoolingServerData> poolData = poolingConnect.connect(searchTerm);
				
		List<MergeResultData> mergeResultList = mergeResults.merge(synchData.getContent(), poolData);
		
		
		
		
		model.addAttribute("noEntries", synchData.getNoEntries());
		model.addAttribute("searchTerm", server.getSearchTerm());
		model.addAttribute("syncData", synchData);
		model.addAttribute("mergeResultList", mergeResultList);
		return "results";
		
	}
}
