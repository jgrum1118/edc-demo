package com.optum.chy.tmp.ggmap;

public class SecondaryDiagnosis {
	String secondaryDiagnosisCd;	// EDC-CCD-SEC-DIAG-CD (25)
	String secondaryTypeCd;			// EDC-CCD-SEC-DIAG-TYP-CD (25)
	
	SecondaryDiagnosis(String xSecondaryDiagnosisCd, String xSecondaryTypeCd) {  
		this.secondaryDiagnosisCd = xSecondaryDiagnosisCd;
		this.secondaryTypeCd = xSecondaryTypeCd;

	}
}
