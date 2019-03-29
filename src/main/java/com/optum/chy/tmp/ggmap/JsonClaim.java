package com.optum.chy.tmp.ggmap;

import java.util.ArrayList;

public class JsonClaim {
	JsonClaimSubmitter claimSubmitter;
	JsonClaimPayer claimPayer;
	JsonPatient patient;
	JsonFacilityClaim facilityClaim;
	JsonServiceSummary serviceSummary;
	JsonDiagnosisSummary diagnosisSummary;
	JsonPolicy policy;
	ArrayList<JsonServiceLine> serviceLines;
	int serviceLineTot;

	public void setClaimSubmitter (JsonClaimSubmitter claimSubmitter) {this.claimSubmitter = claimSubmitter;}
	public void setClaimPayer (JsonClaimPayer claimPayer) {this.claimPayer = claimPayer;}
	public void setPatient (JsonPatient patient) {this.patient = patient;}  
	public void setFacilityClaim (JsonFacilityClaim facilityClaim) {this.facilityClaim = facilityClaim;}
	public void setServiceSummary (JsonServiceSummary serviceSummary) {this.serviceSummary = serviceSummary;}
	public void setDiagnosisSummary (JsonDiagnosisSummary diagnosisSummary) {this.diagnosisSummary = diagnosisSummary;}
	public void setPolicy (JsonPolicy policy) {this.policy = policy;}
	public void setServiceLines (ArrayList<JsonServiceLine> serviceLines) {this.serviceLines = serviceLines;}  
	public void setServiceLineTot (int serviceLineTot) {this.serviceLineTot = serviceLineTot;}

}
