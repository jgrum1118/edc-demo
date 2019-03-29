package com.optum.chy.tmp.ggmap;

import java.util.ArrayList;

public class JsonFacilityClaim {
	String billTypeCode;
	String dischargeStatus;
	ArrayList<String> conditionCode;

	public void setBillTypeCode (String billTypeCode) {this.billTypeCode = billTypeCode;}
	public void setDischargeStatus (String dischargeStatus) {this.dischargeStatus = dischargeStatus;}
	public void setConditionCode (ArrayList<String> conditionCode) {this.conditionCode = conditionCode;}

}
