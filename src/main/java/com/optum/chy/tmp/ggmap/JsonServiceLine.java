package com.optum.chy.tmp.ggmap;

public class JsonServiceLine {
	String lineID;							// EDC-SERVICE-LINE-ID (450)
	double units;							// EDC-UNITS (450)
	String unitsType;						// EDC-UNITS-TYPE (450)
	double billedCharges;					// EDC-BILLED-CHARGES (450)
	String beginDate;						// EDC-SERVICE-START-DATE (450)
	String endDate;							// EDC-SERVICE-END-DATE (450)
	JsonChargeCodes chargeCodes;
	
	public void setLineID (String lineID) {this.lineID = lineID;}
	public void setUnits (double units) {this.units = units;}
	public void setUnitsType (String unitsType) {this.unitsType = unitsType;}
	public void setBilledCharges (double billedCharges) {this.billedCharges = billedCharges;}
	public void setBeginDate (String beginDate) {this.beginDate = beginDate;}
	public void setEndDate (String endDate) {this.endDate = endDate;}
	public void setChargeCodes (JsonChargeCodes chargeCodes) {this.chargeCodes = chargeCodes;}

}