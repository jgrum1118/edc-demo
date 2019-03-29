package com.optum.chy.tmp.ggmap;

public class ReasonforVisitDiagnosis {
	String cd;		// EDC-REAS-VISIT-DX-CD (3)
	String typeCd;	// EDC-REAS-VISIT-DX-TYP-CD (3)
	
	ReasonforVisitDiagnosis(String xCd, String xTypeCd) {  
		this.cd = xCd;
		this.typeCd = xTypeCd;

	}
}
