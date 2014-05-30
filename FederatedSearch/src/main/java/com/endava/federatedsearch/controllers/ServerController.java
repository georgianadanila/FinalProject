package com.endava.federatedsearch.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.endava.federatedsearch.MergeResults;
import com.endava.federatedsearch.connections.PoolingConnect;
import com.endava.federatedsearch.connections.SynchronConnect;
import com.endava.federatedsearch.jpa.service.impl.MergeResultDataMainService;
import com.endava.federatedsearch.models.MergeResultData;
import com.endava.federatedsearch.models.PoolingServerData;
import com.endava.federatedsearch.models.SynchronousServerData;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

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
		ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
		MergeResultDataMainService mergeResultMainService = (MergeResultDataMainService)context.getBean("MergeResultDataMainService");
		List<MergeResultData> mergeResultList;
		SynchronousServerData synchData;
		List<PoolingServerData> poolData;
		
		if  ((mergeResultList = mergeResultMainService.findMergeResultBySearchTerm(searchTerm)) != null) {
			System.out.println("din baza de date!!!");
		}
		else {
			synchData = synchronConnect.connect(searchTerm);	
			poolData = poolingConnect.connect(searchTerm);
			mergeResultList = mergeResults.merge(synchData.getContent(), poolData);
			for (MergeResultData mergeResultData : mergeResultList) {
				mergeResultMainService.insertMergeResultData(mergeResultData);
			}
		
		}
		
		model.addAttribute("searchTerm", server.getSearchTerm());
		model.addAttribute("mergeResultList", mergeResultList);
		return "results";
		
	}
}
