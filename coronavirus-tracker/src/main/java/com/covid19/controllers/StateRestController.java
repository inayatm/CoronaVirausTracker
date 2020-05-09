package com.covid19.controllers;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.covid19.models.LocationStats;
import com.covid19.services.CoronaVirusDataService;
import com.covid19.services.StateDataService;

@RestController
public class StateRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StateRestController.class);
	@Autowired
	StateDataService sateDataService;
	
	String data;

	@RequestMapping("covid19/tracker/states")
	public String fetchStates() {
		LOGGER.info("Inside fetchStates: " );
	
		try {
			data= sateDataService.fetchVirusStateData().toString();
		} catch (IOException | InterruptedException e) {
			
			e.printStackTrace();
		}
		return data;

	}
	
	
	

}
