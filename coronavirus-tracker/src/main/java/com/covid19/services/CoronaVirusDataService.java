package com.covid19.services;


import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.covid19.models.LocationStats;

@Service
public class CoronaVirusDataService {
	
	private static String DATA_VIRUS_URL="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	private  List<LocationStats> listofLocationStat=new ArrayList<>();
  
  @PostConstruct
  @Scheduled(cron="* * 1 * * *")
  public void fetchVirusData() throws IOException, InterruptedException{
	  Logger log=LoggerFactory.getLogger(CoronaVirusDataService.class);
	  log.info("Fetching data from external csv file");
	  HttpClient client=HttpClient.newHttpClient();
	  HttpRequest request=HttpRequest.newBuilder()
			  						.uri(URI.create(DATA_VIRUS_URL))
			  						.build();
	  
	  
	  
	  
	  HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());
	
	  StringReader in = new StringReader(response.body());
	  Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
	   List<LocationStats> newstats=new ArrayList<>();
	  for (CSVRecord record : records) {
		  LocationStats locationstat=new LocationStats();
		  locationstat.setCountry(record.get("Country/Region").trim());
		  locationstat.setState(record.get("Province/State").trim());
		  int totalCasesConfirmed=Integer.parseInt(record.get(record.size()-1));
		  locationstat.setLatestTotal(totalCasesConfirmed);
		  int changeSinceLastDay = totalCasesConfirmed - Integer.parseInt(record.get(record.size()-2));
		  locationstat.setChangeSinceLastDay(changeSinceLastDay);
		  
		  if(locationstat.getCountry().equals("India"))		  
		  log.debug("Indian data: " +locationstat);
		  
		  newstats.add(locationstat);
	   
	  }
	  this.listofLocationStat=newstats;
	  

	 //System.out.println(listofLocationStat);

}

public List<LocationStats> getListofLocationStat() {
	return this.listofLocationStat;
}


}
