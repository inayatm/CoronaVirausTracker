package com.covid19.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.covid19.models.State;
import com.covid19.models.StateTestedData;




@Service
public class StateDataService {
	Logger log=LoggerFactory.getLogger(StateDataService.class);
	private static String STATE_DATA_URL="https://api.covid19india.org/state_test_data.json";
	
  @Scheduled(cron="* * 1 * * *")
  public List<StateTestedData> fetchVirusStateData() {
	  
	  RestTemplate template=new RestTemplate();
	  
	  List<StateTestedData> stateTestedData=template.getForObject(STATE_DATA_URL, State.class).getStatedata();
	  log.info("State data of size "+stateTestedData.size() +" has been retriewed");
	  return stateTestedData;
  }

}
