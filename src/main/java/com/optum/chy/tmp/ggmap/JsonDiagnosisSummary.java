package com.optum.chy.tmp.ggmap;

import java.util.ArrayList;

public class JsonDiagnosisSummary {
	String admitDiagnosis;
	String admitDiagnosisTypeCd;
	String primaryDiagnosis;
	String typeCd;
	ArrayList<JsonSecondaryDiagnosis> secondaryDiagnosis;
	ArrayList<JsonReasonforVisitDiagnosis> reasonforVisitDiagnosis;

	public void setAdmitDiagnosis (String admitDiagnosis) {this.admitDiagnosis = admitDiagnosis;}
	public void setAdmitDiagnosisTypeCd (String admitDiagnosisTypeCd) {this.admitDiagnosisTypeCd = admitDiagnosisTypeCd;}
	public void setPrimaryDiagnosis (String primaryDiagnosis) {this.primaryDiagnosis = primaryDiagnosis;}
	public void setTypeCd (String typeCd) {this.typeCd = typeCd;}
	public void setSecondaryDiagnosis (ArrayList<JsonSecondaryDiagnosis> secondaryDiagnosis) {this.secondaryDiagnosis = secondaryDiagnosis;}
	public void setReasonforVisitDiagnosis (ArrayList<JsonReasonforVisitDiagnosis> reasonforVisitDiagnosis) {this.reasonforVisitDiagnosis = reasonforVisitDiagnosis;}

}
