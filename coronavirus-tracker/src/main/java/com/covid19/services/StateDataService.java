package com.covid19.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.covid19.models.LocationStats;
import com.covid19.models.State;
import com.covid19.models.StateTestedData;




@Service
public class StateDataService {
	
	private static String STATE_DATA_URL="https://api.covid19india.org/state_test_data.json";
	
	
	

  @PostConstruct
  @Scheduled(cron="* * 1 * * *")
  public List<StateTestedData> fetchVirusStateData() {
	  System.out.println("Service calling..");
	  
	  
	  HttpClient client=HttpClient.newHttpClient();
	  HttpRequest request=HttpRequest.newBuilder()
			  						.uri(URI.create(STATE_DATA_URL))
			  						.build();
	  
	  
	  RestTemplate template=new RestTemplate();
	  
	  List<StateTestedData> stateTestedData=template.getForObject(STATE_DATA_URL, State.class).getStatedata();
	  
	  System.out.println(stateTestedData.get(0));
	  return stateTestedData;
  }

}
