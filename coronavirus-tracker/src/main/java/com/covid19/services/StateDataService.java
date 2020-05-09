package com.covid19.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;




@Service
public class StateDataService {
	
	private static String STATE_DATA_URL="https://api.covid19india.org/state_test_data.json";

  @PostConstruct
  @Scheduled(cron="* * 1 * * *")
  public Object fetchVirusStateData() throws IOException, InterruptedException{
	  System.out.println("Service calling..");
	  
	  
	  HttpClient client=HttpClient.newHttpClient();
	  HttpRequest request=HttpRequest.newBuilder()
			  						.uri(URI.create(STATE_DATA_URL))
			  						.build();
	  
	  HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());
	  
	  StringReader in = new StringReader(response.body());
	  Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
	   //List<LocationStats> newstats=new ArrayList<>();
	  for (CSVRecord record : records) {
	  System.out.println(record.getRecordNumber());
	  
	  }
	 return response.body();
  }

}
