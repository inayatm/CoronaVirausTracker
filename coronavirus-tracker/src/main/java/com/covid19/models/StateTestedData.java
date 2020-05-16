package com.covid19.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown =true )
public class StateTestedData {
	
	//coronaenquirycalls
		//cumulativepeopleinquarantine
		private int negative;
		//numcallsstatehelpline
		//numicubeds
		private int numisolationbeds;
		private int numventilators;
		private int populationncp2019projection;
		private int positive;
		private String source1;
		private String state;
		private String tagpeopleinquarantine;
		private String tagtotaltested;
		private String testpositivityrate;
		private int testspermillion;
		private double testsperthousand;
		private int totalpeoplecurrentlyinquarantine;
		private int totalpeoplereleasedfromquarantine;
		private int totaltested;
		private int unconfirmed;
		//updatedon
		public int getNegative() {
			return negative;
		}
		public void setNegative(int negative) {
			this.negative = negative;
		}
		public int getNumisolationbeds() {
			return numisolationbeds;
		}
		public void setNumisolationbeds(int numisolationbeds) {
			this.numisolationbeds = numisolationbeds;
		}
		public int getNumventilators() {
			return numventilators;
		}
		public void setNumventilators(int numventilators) {
			this.numventilators = numventilators;
		}
		public int getPopulationncp2019projection() {
			return populationncp2019projection;
		}
		public void setPopulationncp2019projection(int populationncp2019projection) {
			this.populationncp2019projection = populationncp2019projection;
		}
		public int getPositive() {
			return positive;
		}
		public void setPositive(int positive) {
			this.positive = positive;
		}
		public String getSource1() {
			return source1;
		}
		public void setSource1(String source1) {
			this.source1 = source1;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getTagpeopleinquarantine() {
			return tagpeopleinquarantine;
		}
		public void setTagpeopleinquarantine(String tagpeopleinquarantine) {
			this.tagpeopleinquarantine = tagpeopleinquarantine;
		}
		public String getTagtotaltested() {
			return tagtotaltested;
		}
		public void setTagtotaltested(String tagtotaltested) {
			this.tagtotaltested = tagtotaltested;
		}
		public String getTestpositivityrate() {
			return testpositivityrate;
		}
		public void setTestpositivityrate(String testpositivityrate) {
			this.testpositivityrate = testpositivityrate;
		}
		public int getTestspermillion() {
			return testspermillion;
		}
		public void setTestspermillion(int testspermillion) {
			this.testspermillion = testspermillion;
		}
		public double getTestsperthousand() {
			return testsperthousand;
		}
		public void setTestsperthousand(double testsperthousand) {
			this.testsperthousand = testsperthousand;
		}
		public int getTotalpeoplecurrentlyinquarantine() {
			return totalpeoplecurrentlyinquarantine;
		}
		public void setTotalpeoplecurrentlyinquarantine(int totalpeoplecurrentlyinquarantine) {
			this.totalpeoplecurrentlyinquarantine = totalpeoplecurrentlyinquarantine;
		}
		public int getTotalpeoplereleasedfromquarantine() {
			return totalpeoplereleasedfromquarantine;
		}
		public void setTotalpeoplereleasedfromquarantine(int totalpeoplereleasedfromquarantine) {
			this.totalpeoplereleasedfromquarantine = totalpeoplereleasedfromquarantine;
		}
		public int getTotaltested() {
			return totaltested;
		}
		public void setTotaltested(int totaltested) {
			this.totaltested = totaltested;
		}
		public int getUnconfirmed() {
			return unconfirmed;
		}
		public void setUnconfirmed(int unconfirmed) {
			this.unconfirmed = unconfirmed;
		}
		@Override
		public String toString() {
			return "State [negative=" + negative + ", numisolationbeds=" + numisolationbeds + ", numventilators="
					+ numventilators + ", populationncp2019projection=" + populationncp2019projection + ", positive="
					+ positive + ", source1=" + source1 + ", state=" + state + ", tagpeopleinquarantine="
					+ tagpeopleinquarantine + ", tagtotaltested=" + tagtotaltested + ", testpositivityrate="
					+ testpositivityrate + ", testspermillion=" + testspermillion + ", testsperthousand=" + testsperthousand
					+ ", totalpeoplecurrentlyinquarantine=" + totalpeoplecurrentlyinquarantine
					+ ", totalpeoplereleasedfromquarantine=" + totalpeoplereleasedfromquarantine + ", totaltested="
					+ totaltested + ", unconfirmed=" + unconfirmed + "]";
		}
		

}
