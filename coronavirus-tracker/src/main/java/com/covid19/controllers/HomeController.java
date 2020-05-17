package com.covid19.controllers;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import  org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.covid19.models.LocationStats;
import com.covid19.services.CoronaVirusDataService;

@Controller
@RequestMapping("/covid19/tracker")
public class HomeController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	 CoronaVirusDataService dataservice;
    private List<LocationStats> alllocstats;
    List<LocationStats> matchedCountries ;
    	
	@GetMapping("/home")
	public String home(Model model) {
		
try {
	        alllocstats=dataservice.getListofLocationStat();
			dataservice.fetchVirusData();
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int totalNoOfcases=alllocstats.stream().mapToInt(mapper->mapper.getLatestTotal()).sum();
		model.addAttribute("locationstatList",alllocstats);
		NumberFormat numberformat=NumberFormat.getNumberInstance(Locale.US);
		model.addAttribute("totalNoOfcases",numberformat.format(totalNoOfcases));
		String diffSinceLastDay=alllocstats.stream().mapToInt(mapper->mapper.getChangeSinceLastDay()).toString();
		model.addAttribute("changeSinceLastDay",diffSinceLastDay);
		LOGGER.info("Rendering home view");
		return "home";
	}

	public List<LocationStats> getAlllocstats() {
		return alllocstats;
	}

	public void setAlllocstats(List<LocationStats> alllocstats) {
		this.alllocstats = alllocstats;
	}
	

}