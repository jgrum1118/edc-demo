package com.optum.chy.tmp.ggmap;

public class JsonClaimPrice {
	String requestType;
	String parInd;
	JsonClaim claim;
	String icd9ICD10Cd;

	public void setRequestType (String requestType) {this.requestType = requestType;}  
	public void setParInd (String parInd) {this.parInd = parInd;} 
	public void setClaim (JsonClaim claim) {this.claim = claim;}
	public void setIcd9ICD10Cd (String icd9ICD10Cd) {this.icd9ICD10Cd = icd9ICD10Cd;} 

}
