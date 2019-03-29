package com.optum.chy.tmp.ggmap;

public class ServiceLines {
	
	String lineID;							// EDC-SERVICE-LINE-ID (450)
	String units;							// EDC-UNITS (450)
	String unitsType;						// EDC-UNITS-TYPE (450)
	String billedCharges;					// EDC-BILLED-CHARGES (450)
	String beginDate;						// EDC-SERVICE-START-DATE (450)
	String endDate;							// EDC-SERVICE-END-DATE (450)
	String cptCode;
    String cptModifier1;	
    String cptModifier2;	
    String cptModifier3;	
    String cptModifier4;	

	
	ServiceLines(String xLineID, String xUnits, String xUnitsType, String xBilledCharges, String xBeginDate,
			 String xEndDate, String xCptCode, String xCptModifier1, String xCptModifier2, String xCptModifier3, String xCptModifier4) {  

		this.lineID = xLineID;
		this.units = xUnits;
		this.unitsType = xUnitsType;
		this.billedCharges = xBilledCharges;
		this.beginDate = xBeginDate;
		this.endDate = xEndDate;
		this.cptCode = xCptCode;
		this.cptModifier1 = xCptModifier1;	
		this.cptModifier2 = xCptModifier2;	
		this.cptModifier3 = xCptModifier3;	
		this.cptModifier4 = xCptModifier4;	
		
	}
}

