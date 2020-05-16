package com.covid19.models;


import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class State {
	
   @JsonProperty("states_tested_data")
	private List<StateTestedData> statedata;

public List<StateTestedData> getStatedata() {
	return statedata;
}

public void setStatedata(List<StateTestedData> statedata) {
	this.statedata = statedata;
}

@Override
public String toString() {
	return "State [statedata=" + statedata + "]";
}


	
	
}
